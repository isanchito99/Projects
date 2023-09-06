lambda = 30; %Número de hijos
mu = 10; % Número de padres
sigma = 0.3; %Establecemos la variable sigma
iteraciones = 5000; %Establecemos el número de iteraciones (generaciones)
padre = -100 + (100+100)*rand(1,30); %Creamos el padre.
vector_fitness = zeros(1,iteraciones);  %Vector para almacenar fitness

figure;
xlabel("generaciones");
ylabel("fitness");
hold on;

for i = 1:iteraciones
    for index_padre = 1:size(padre,1)
       hijos = padre(index_padre,:) + sigma*randn(1,30); %sigma.*randn(mu,size(padre,2));
       fitness_hijos = sum(hijos.^2,2);
       [minimum,mejor_hijo] = min(fitness_hijos);

       if minimum < sum(padre(index_padre,:).^2)
           padre(index_padre,:) = hijos(mejor_hijo,:);
       end
    end

    fitness_padres = sum(padre.^2,2);
    [menor_fitness,mejor_solucion] = min(fitness_padres);
    vector_fitness(i) = menor_fitness;
    plot(i, menor_fitness,"-o");
end



%A menor fitnss, mejor será la solucion, por ello en la representación
%gráfica va hacia abajo hasta la generación 1000 lo cual representa que van
%mejorando de manera radical. Pero luego a las siguientes generaciones les
%cuesta más mejorar. (El resultado final es el fitness final de la última
%generación)
%



