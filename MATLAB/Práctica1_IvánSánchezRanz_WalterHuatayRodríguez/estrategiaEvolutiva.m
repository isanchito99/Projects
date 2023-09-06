%Implementación de la estrategia evolutiva (1+1), un individuo padre muta a
% a partir del ruido Gaussiano, el cual será representado con el nombre de
% la variable "Sigma".


sigma=0.5; % Establecemos la variable sigma para la mutación en 0,5
padre = -100 + (100+100)*rand(1,30); % Se crea al padre con valores entre -100 y 100.
fitnessPadre = sum(padre.^2); %Almacenamos el valor fitness del padre.
iteracion = 5000; %Creamos las iteraciones (generaciones) durante las que tendrá lugar esta estrategia evolutiva

%Preparamos la representación gráfica de la estrategia evolutiva 
figure;
xlabel("generaciones"); % Eje Y
ylabel("fitness");  % Eje X
hold on;

for i= 1:iteracion % Creamos el bucle que se realizará durante todas las generaciones.
   hijo = padre + sigma*randn(1,30); % Creamos el hijo a partir del padre gracias al sigma.
   fitnessHijo = sum(hijo.^2);   %Almacenamos el valor fitness del hijo
   if (fitnessHijo < fitnessPadre) % Establemos la condición: Si el fitness del hijo es menor que el del padre.
    fitnessPadre = fitnessHijo; %Si el fitness del hijo es menor (mejor) se almacena como fitness padre.
    padre=hijo; % Y el padre pasaría a ser el hijo superviviente al tener mejor fitness.
   end
   plot(i,fitnessPadre,"-o"); % Se representa la variable fitnessPadre, la cual es la mejor de cada iteración. 
end
hold off;





