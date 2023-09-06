%Algoritmo Genético

%Vector de longitud 1000
filas = 100; % Número de indiviudos
filasMitad= filas/2;
columnas = 1000; % Número de elementos de cada individuo
poblacion = randi([0 1],filas,columnas); % Se genera la población

figure;
xlabel("generaciones");
ylabel("fitness");
hold on;

%Fitness
fitnessPoblacion =  max(sum(poblacion==1,2)); %FitnessPoblacion guardará el número de 1 que posee el individuo que más posea.
vectorFitness = sum(poblacion==1,2); %Genera metriz de 100x1, cada elemento contiene el sumatorio de número de 1 que tiene cada individuo

for i=1:5000
    vectorFitness = sum(poblacion==1,2);
    fitnessPoblacion1 =  max(sum(poblacion==1,2));
    total1 = sum(sum(poblacion==1,2));

    %Seleccion
    longitud = length(vectorFitness);
    [lista,indices] = sort(vectorFitness,'descend'); %Ordenamos por orden descendente a los valores fitness
    indicesSeleccionados = indices(1:longitud/2); % Se seleccionan los mejores 50 individuos basados en el fitness
    selec = poblacion(indicesSeleccionados,:); %Almacenamos los 50 mejores individuos que serán utilizados para obtener los individuos de la poblacion

    poblacionSeleccionada = selec;
    poblacion(1:filasMitad,1:columnas) = poblacionSeleccionada;

    
    %Cruce - generamos las poblaciones resultantes de los cruces entre
    %indiviudos:
    poblacionCruzada = cruzar(poblacion,poblacionSeleccionada);
    poblacion(filasMitad+1:filas,1:columnas) = poblacionCruzada;


    %Mutacion
    umbralMutacion=0.3;  %Definimos umbral de mutación.
    probabilidadMutacion = rand(); %Definimos la probabilidad aleatoria entre 0 y 1.
    if(umbralMutacion>probabilidadMutacion) %Por debajo del umbral se producirá mutación.
           aleatorio_PosicionColumnas = randi([1 columnas]); % Se elige el elemento (posicion) a mutar.
           aleatorio_PosicionFilas = randi([1 filas]);
           poblacion(aleatorio_PosicionFilas,aleatorio_PosicionColumnas) = ...
             1 - poblacion(aleatorio_PosicionFilas,aleatorio_PosicionColumnas);
            
    end
    fitnessPoblacion =  max(sum(poblacion==1,2));

    plot (i,fitnessPoblacion, "-o");
end
