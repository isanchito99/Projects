%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% WinSym Code
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all; close all; clc;
addpath('utils/');addpath('dt/')
load('dt/pwrCurve.mat');

%% Load Data
load('WindSym_1.mat');

%% Kgr Grid with Nturb Turbines
Kgr = 20;   % Tamaño del Grid
Nturb = 20; % Numero de Turbinas
promptIndi = "Cuantos Individuos deseas: ";
individuos = input(promptIndi);

%Se genera población
poblacion = zeros(individuos,Kgr*Kgr);%generamos un vector de 400
for i=1:individuos
    poblacion(i,randperm(Kgr*Kgr,Nturb))=1;
end
for i=1:individuos
    [lista,indices] = sort(poblacion(i,:),'descend');
    indicesGenera(i,:) = indices(1:20);
end
indices = indicesGenera;
%Llamamos al main

final=main(vVec,poblacion,indices,individuos);
disp("                                               MATRIZ RESULTANTE")
disp(final)
% Ouputs: pwr_t: Potencia Total
%         pwrGen: Potencia Individual por Generador
%         Ux: Viento en cada Generador
%         gan: Precio (KW) * Potencia Total
%         cost: Coste de las Turbinas
%         obj: cost / gan
[pwr_T2,gan_T2,cost_T2,obj_T2] = f_powerPlantsT_fast(vVec,final);

disp("POTENCIA GENERADA")
disp(pwr_T2)


