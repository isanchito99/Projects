function cruceFinal = cruzar(indicesCruce,poblacionSelec)
%Tenemos por parámetro los índices y la
% poblacion seleccionada anteriormente
longitud = length(indicesCruce(1,:));
filasPoblacion = length(poblacionSelec(:,1)); %cogemos todas las filas de la poblaciçon seleccionada
cruceFinal = zeros(filasPoblacion,longitud); %Aqui guardaremos los cruzados
cruces = zeros(2,longitud);
for i=1:2:length(poblacionSelec(:,2)) %SOLAMENTE QUEREMOS COGER LOS 2 PRIMEROS ELEMENTOS
    %Generamos los 2 primeros padres
    primerPadre = poblacionSelec(i,:); %1padre
    segundoPadre = poblacionSelec(i+1,:);%2padre
    %Cogemos una mitad aleatoria de la longitud de los indices
    mitadIndicesAleatoria = randi([1 longitud]);
    % PRIMER CRUCE
    cruces(1,1:mitadIndicesAleatoria) = primerPadre(1:mitadIndicesAleatoria);
    cruces(1,mitadIndicesAleatoria + 1:longitud) =segundoPadre(mitadIndicesAleatoria + 1:longitud);
    %SEGUNDO CRUCE
    cruces(2,1:mitadIndicesAleatoria) = segundoPadre(1:mitadIndicesAleatoria);
    cruces(2,mitadIndicesAleatoria + 1:longitud) =primerPadre(mitadIndicesAleatoria + 1:longitud);
    %devolvemos finalmente los cruces finales
    cruceFinal(i,1:longitud) = cruces(1,:);%cruce1
    cruceFinal(i+1,1:longitud) = cruces(2,:);%cruce2
end
end