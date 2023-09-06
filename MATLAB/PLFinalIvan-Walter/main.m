function matrizFinal = main(vVec,poblacion,indices,individuos)
%AQUI SE REALIZARÁN EL Nº DE ITERACIONES EN LA EJECUCIÓN
prompt = "Cuantas Iteraciones deseas: ";
iteracionesBucleImput = input(prompt);%Variable encargada de pedir al usuario cuantas iteraciones quiere
pedirUmbral = "Cuanto umbral de mutación ponemos (valor entre 0 y 1): (EJEMPLO = 0.5) ";
umbralInput=input(pedirUmbral);
filas = length(indices(:,1));
columnas = length(indices(1,:));
mitadFilas= filas/2;
figure;
xlabel("individuos");
ylabel("fitness");
hold on;

% NOS ENCARGAMOS DE RECORRER TODAS LAS COLUMNAS Y MODIFICAR LA MATRIZ%
for iteraciones=1:iteracionesBucleImput %se hace un bucle dependiendo de las iteraciones que queramos
    if(umbralInput<0 || umbralInput>1)
        disp("EL UMBRAL DEBE TENER UN VALOR ENTRE 0 Y 1, SE VA A CERRAR EL PROGRAMA")
        break
    end
    disp(iteraciones) %imprime en que iteración estamos
    columnasPoblacion=length(poblacion(:,1)); %cogemos la longitud de las columnas de población
    columnasPobZeros=zeros(columnasPoblacion,1);
    for recorrerColumnas=1:length(poblacion(:,1))
        conversion = reshape(poblacion(recorrerColumnas,:),[20,20]); %Remoleda la matriz, pasa de vector de 400 a matriz 20x20

        [pwr_T2,gan_T2,cost_T2,obj_T2] = f_powerPlantsT_fast(vVec,conversion);
        columnasPobZeros(recorrerColumnas) = pwr_T2;
    end
    vectorFit=columnasPobZeros;

    %SELECCIONAMOS LOS MEJORES INDIVIDUOS DE LA ANTERIOR POBLACIÓN
    longitud=length(vectorFit);
    [lista,indicesNuevos]=sort(vectorFit,'descend');
    indicesSelec=indicesNuevos(1:longitud/2);
    poblacionSelec=indices(indicesSelec,:);
    indices(1:mitadFilas,1:columnas) = poblacionSelec;

    %CRUZAMOS LOS INDIVIDUOS PARA OBTENER HIJOS

    poblacionCruzada= cruzar(indices,poblacionSelec);
    indices(mitadFilas+1:filas,1:columnas) = poblacionCruzada;

    %MUTAR
    umbralMutacion=umbralInput; %podemos poner un valor cualquiera entre 0 y 1
    for j=1:iteracionesBucleImput
        probabilidadMutar = rand(1); %solo queremos generar un unico nºrandom
        if(umbralMutacion<probabilidadMutar)
            posicionColumnasRandi = randi([1 columnas]); %Numero aleatorio de columna
            posicionFilasRandi = randi([1 filas]); %Numero aleatorio de fila
            if(indices(posicionFilasRandi,posicionColumnasRandi)==1)
                indices(posicionFilasRandi,posicionColumnasRandi)=...
                    indices(posicionFilasRandi,posicionColumnasRandi) + 1;
            else
                indices(posicionFilasRandi,posicionColumnasRandi)=...
                    indices(posicionFilasRandi,posicionColumnasRandi) - 1;
            end
        end
    end

    %Creamos población con los nuevos elementos
    %SE GENERA LA MATRIZ CON LOS MOLINOS, DONDE HAYA 1 SERÁ
    %DONDE HAYA UN MOLINO
    matrizPob = zeros(individuos,400);
    for bucleIndividuos=1:individuos
        matrizPob(bucleIndividuos,indices(bucleIndividuos,:)) = 1;
    end
    %MOSTRAR TODOS LOS VALORES FITNESS, LA GRÁFICA Y
    %LA MATRIZ RESULTANTE FINAL
    vectorFit
    poblacion=matrizPob;
    plot (vectorFit,individuos, "o-");
    hold off;
end
[lista,indices] = sort(vectorFit,'descend');
matrizFinal = reshape(poblacion(indices(1),:),[20,20]);
