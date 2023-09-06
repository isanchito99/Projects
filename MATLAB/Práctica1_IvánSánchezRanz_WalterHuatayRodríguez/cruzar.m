function cruzar = cruzar(m,poblacionSeleccionada)
    long = length(m(1,:));
    filas = length(poblacionSeleccionada(:,1));
    cruzar = zeros(filas,long);
    descendencia = zeros(2,long);
    for i=1:2:length(poblacionSeleccionada(:,2))
        %Se seleccionan los dos primeros padres
        padre1 = poblacionSeleccionada(i,:);
        padre2 = poblacionSeleccionada(i+1,:);
        
        %En el vector descendencia se encuentran los hijos de los padres, que se
        %han cruzado
        
        %Hijo 1
        descendencia(1,1:long/2) = padre1(1:long/2);
        descendencia(1,long/2 + 1:long) =padre2(long/2 + 1:long);
        
        %Hijo 2
        descendencia(2,1:long/2) = padre2(1:long/2);
        descendencia(2,long/2 + 1:long) =padre1(long/2 + 1:long);
        
        %Se añade al vector cruzados, que es el que devolveremos
        cruzar(i,1:long) = descendencia(1,:);
        cruzar(i+1,1:long) = descendencia(2,:);
    end
end