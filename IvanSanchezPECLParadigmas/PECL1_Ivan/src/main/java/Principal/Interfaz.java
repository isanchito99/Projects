/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import Distribuida.ObjetoRemoto;
import java.awt.Color;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Interfaz extends javax.swing.JFrame {

    private int numero_personas;
    private boolean parado = false;
    private boolean reanudado = false;
    private Pausar pausaGlobal = new Pausar();
    private Pausar pausaEmpleado1 = new Pausar();
    private Pausar pausaEmpleado2 = new Pausar();
    private Pausar pausaEmpleado3 = new Pausar();
    private Pausar pausaEmpleado4 = new Pausar();
    private Pausar pausaEmpleado5 = new Pausar();

    public Interfaz() {
        initComponents();
        Registro log = new Registro();
        numero_personas = 401;

        Buzon buzon = new Buzon(30, jTextPane1, jTextPane2);
        Furgoneta furgoneta = new Furgoneta(jTextPane8, jTextPane9, log);
        Empleado e1 = new Empleado(buzon, furgoneta, "Empleado1", jTextPane3, log, pausaEmpleado1);//pausaEmpleado1
        Empleado e2 = new Empleado(buzon, furgoneta, "Empleado2", jTextPane4, log, pausaEmpleado2);//pausaEmpleado2
        Empleado e3 = new Empleado(buzon, furgoneta, "Empleado3", jTextPane5, log, pausaEmpleado3);//pausa1Empleado3
        Empleado e4 = new Empleado(buzon, furgoneta, "Empleado4", jTextPane6, log, pausaEmpleado4);//pausa1Empleado4
        Empleado e5 = new Empleado(buzon, furgoneta, "Empleado5", jTextPane7, log, pausaEmpleado5);//pausaEmpleado5
        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();

        for (int i = 1; i < numero_personas; i++) {
            Persona p = new Persona(buzon, "Persona" + i, log, pausaGlobal);
            p.start();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton_PausarRenaudarTodo = new javax.swing.JButton();
        pausarReanudarEmpleado1 = new javax.swing.JButton();
        pausarReanudarEmpleado2 = new javax.swing.JButton();
        pausarReanudarEmpleado3 = new javax.swing.JButton();
        pausarReanudarEmpleado4 = new javax.swing.JButton();
        pausarReanudarEmpleado5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa Principal");
        setBackground(new java.awt.Color(102, 255, 204));

        jLabel1.setText("Contenido del buzón:");

        jLabel2.setText("Número de cartas del buzón:");

        jLabel3.setText("Empleado 1:");

        jLabel4.setText("Empleado 5:");

        jLabel6.setText("Empleado 3:");

        jLabel7.setText("Empleado 4:");

        jLabel8.setText("Contenido de la Fugoneta 1:");

        jLabel9.setText("Contenido de la Fugoneta 2:");

        jButton_PausarRenaudarTodo.setBackground(new java.awt.Color(255, 204, 204));
        jButton_PausarRenaudarTodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_PausarRenaudarTodo.setText("Pausar/Reanudar Todo");
        jButton_PausarRenaudarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_PausarRenaudarTodoMouseClicked(evt);
            }
        });
        jButton_PausarRenaudarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PausarRenaudarTodoActionPerformed(evt);
            }
        });

        pausarReanudarEmpleado1.setBackground(new java.awt.Color(255, 153, 153));
        pausarReanudarEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarReanudarEmpleado1.setText("Pausar/Reanudar Empleado 1");
        pausarReanudarEmpleado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausarReanudarEmpleado1MouseClicked(evt);
            }
        });
        pausarReanudarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarReanudarEmpleado1ActionPerformed(evt);
            }
        });

        pausarReanudarEmpleado2.setBackground(new java.awt.Color(255, 153, 153));
        pausarReanudarEmpleado2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarReanudarEmpleado2.setText("Pausar/Reanudar Empleado 2");
        pausarReanudarEmpleado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausarReanudarEmpleado2MouseClicked(evt);
            }
        });
        pausarReanudarEmpleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarReanudarEmpleado2ActionPerformed(evt);
            }
        });

        pausarReanudarEmpleado3.setBackground(new java.awt.Color(255, 153, 153));
        pausarReanudarEmpleado3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarReanudarEmpleado3.setText("Pausar/Reanudar Empleado 3");
        pausarReanudarEmpleado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausarReanudarEmpleado3MouseClicked(evt);
            }
        });

        pausarReanudarEmpleado4.setBackground(new java.awt.Color(255, 153, 153));
        pausarReanudarEmpleado4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarReanudarEmpleado4.setText("Pausar/Reanudar Empleado 4");
        pausarReanudarEmpleado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausarReanudarEmpleado4MouseClicked(evt);
            }
        });

        pausarReanudarEmpleado5.setBackground(new java.awt.Color(255, 153, 153));
        pausarReanudarEmpleado5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarReanudarEmpleado5.setText("Pausar/Reanudar Empleado 5");
        pausarReanudarEmpleado5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausarReanudarEmpleado5MouseClicked(evt);
            }
        });

        jLabel10.setText("Empleado 2:");

        jTextPane1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jTextPane2);

        jScrollPane3.setViewportView(jTextPane3);

        jScrollPane4.setViewportView(jTextPane4);

        jScrollPane5.setViewportView(jTextPane5);

        jScrollPane6.setViewportView(jTextPane6);

        jScrollPane7.setViewportView(jTextPane7);

        jScrollPane8.setViewportView(jTextPane8);

        jScrollPane9.setViewportView(jTextPane9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(41, 41, 41)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pausarReanudarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pausarReanudarEmpleado2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pausarReanudarEmpleado3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pausarReanudarEmpleado4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jButton_PausarRenaudarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pausarReanudarEmpleado5, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(322, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(484, 484, 484))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pausarReanudarEmpleado1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(pausarReanudarEmpleado2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(pausarReanudarEmpleado3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pausarReanudarEmpleado4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pausarReanudarEmpleado5)))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton_PausarRenaudarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(293, 293, 293))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_PausarRenaudarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PausarRenaudarTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_PausarRenaudarTodoActionPerformed

    private void jButton_PausarRenaudarTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PausarRenaudarTodoMouseClicked

        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaGlobal.cerrar();
            //*************************************

            pausaEmpleado1.cerrar();

            pausarReanudarEmpleado1.setText("VOLVER A FUNCIONAR");
            jTextPane3.setText("PAUSADO");
            pausarReanudarEmpleado1.setBackground(Color.green);
            pausarReanudarEmpleado1.setForeground(Color.black);
            //*************************************

            pausaEmpleado2.cerrar();
            pausarReanudarEmpleado2.setText("VOLVER A FUNCIONAR");
            jTextPane4.setText("PAUSADO");
            pausarReanudarEmpleado2.setBackground(Color.green);
            pausarReanudarEmpleado2.setForeground(Color.black);
            //*************************************

            pausaEmpleado3.cerrar();
            pausarReanudarEmpleado3.setText("VOLVER A FUNCIONAR");
            jTextPane5.setText("PAUSADO");
            pausarReanudarEmpleado3.setBackground(Color.green);
            pausarReanudarEmpleado3.setForeground(Color.black);
            //*************************************

            pausaEmpleado4.cerrar();
            pausarReanudarEmpleado4.setText("VOLVER A FUNCIONAR");
            jTextPane6.setText("PAUSADO");
            pausarReanudarEmpleado4.setBackground(Color.green);
            pausarReanudarEmpleado4.setForeground(Color.black);

            //*************************************
            pausaEmpleado5.cerrar();
            pausarReanudarEmpleado5.setText("VOLVER A FUNCIONAR");
            jTextPane7.setText("PAUSADO");
            pausarReanudarEmpleado5.setBackground(Color.green);
            pausarReanudarEmpleado5.setForeground(Color.black);

        } else { //Pero si ya lo ha pusaldo entocnes se reanuda.
            reanudado = true;
            parado = false;
            pausaGlobal.abrir();

            //*************************************
            pausaEmpleado1.abrir();
            pausarReanudarEmpleado1.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado1.setBackground(Color.red);
            pausarReanudarEmpleado1.setForeground(Color.white);

            //*************************************
            pausaEmpleado2.abrir();
            pausarReanudarEmpleado2.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado2.setBackground(Color.red);
            pausarReanudarEmpleado2.setForeground(Color.white);
            //*************************************

            pausaEmpleado3.abrir();
            pausarReanudarEmpleado3.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado3.setBackground(Color.red);
            pausarReanudarEmpleado3.setForeground(Color.white);
            //*************************************
            pausaEmpleado4.abrir();
            pausarReanudarEmpleado4.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado4.setBackground(Color.red);
            pausarReanudarEmpleado4.setForeground(Color.white);
            //*************************************

            pausaEmpleado5.abrir();
            pausarReanudarEmpleado5.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado5.setBackground(Color.red);
            pausarReanudarEmpleado5.setForeground(Color.white);
        }
    }//GEN-LAST:event_jButton_PausarRenaudarTodoMouseClicked

    private void pausarReanudarEmpleado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado1MouseClicked

        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaEmpleado1.cerrar();
            pausarReanudarEmpleado1.setText("VOLVER A FUNCIONAR");
            jTextPane3.setText("PAUSADO");
            pausarReanudarEmpleado1.setBackground(Color.green);
            pausarReanudarEmpleado1.setForeground(Color.black);

        } else { //Pero si ya lo ha pusaldo entonces se reanuda.
            reanudado = true;
            parado = false;
            pausaEmpleado1.abrir();
            pausarReanudarEmpleado1.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado1.setBackground(Color.red);
            pausarReanudarEmpleado1.setForeground(Color.white);

        }
    }//GEN-LAST:event_pausarReanudarEmpleado1MouseClicked

    private void pausarReanudarEmpleado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado2MouseClicked
        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaEmpleado2.cerrar();
            pausarReanudarEmpleado2.setText("VOLVER A FUNCIONAR");
            jTextPane4.setText("PAUSADO");
            pausarReanudarEmpleado2.setBackground(Color.green);
            pausarReanudarEmpleado2.setForeground(Color.black);
        } else { //Pero si ya lo ha pusaldo entonces se reanuda.
            reanudado = true;
            parado = false;
            pausaEmpleado2.abrir();
            pausarReanudarEmpleado2.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado2.setBackground(Color.red);
            pausarReanudarEmpleado2.setForeground(Color.white);

        }
    }//GEN-LAST:event_pausarReanudarEmpleado2MouseClicked

    private void pausarReanudarEmpleado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado3MouseClicked

        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaEmpleado3.cerrar();
            pausarReanudarEmpleado3.setText("VOLVER A FUNCIONAR");
            jTextPane5.setText("PAUSADO");
            pausarReanudarEmpleado3.setBackground(Color.green);
            pausarReanudarEmpleado3.setForeground(Color.black);

        } else { //Pero si ya lo ha pusaldo entonces se reanuda.
            reanudado = true;
            parado = false;
            pausaEmpleado3.abrir();
            pausarReanudarEmpleado3.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado3.setBackground(Color.red);
            pausarReanudarEmpleado3.setForeground(Color.white);

        }
    }//GEN-LAST:event_pausarReanudarEmpleado3MouseClicked

    private void pausarReanudarEmpleado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado4MouseClicked

        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaEmpleado4.cerrar();
            pausarReanudarEmpleado4.setText("VOLVER A FUNCIONAR");
            jTextPane6.setText("PAUSADO");
            pausarReanudarEmpleado4.setBackground(Color.green);
            pausarReanudarEmpleado4.setForeground(Color.black);

        } else { //Pero si ya lo ha pusaldo entonces se reanuda.
            reanudado = true;
            parado = false;
            pausaEmpleado4.abrir();
            pausarReanudarEmpleado4.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado4.setBackground(Color.red);
            pausarReanudarEmpleado4.setForeground(Color.white);
        }
    }//GEN-LAST:event_pausarReanudarEmpleado4MouseClicked

    private void pausarReanudarEmpleado5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado5MouseClicked

        if (!parado) { //Si no lo ha pulsado entonces se para.
            parado = true;
            reanudado = false;
            pausaEmpleado5.cerrar();
            pausarReanudarEmpleado5.setText("VOLVER A FUNCIONAR");
            jTextPane7.setText("PAUSADO");
            pausarReanudarEmpleado5.setBackground(Color.green);
            pausarReanudarEmpleado5.setForeground(Color.black);

        } else { //Pero si ya lo ha pusaldo entonces se reanuda.
            reanudado = true;
            parado = false;
            pausaEmpleado5.abrir();
            pausarReanudarEmpleado5.setText("PARAR A DESCANSAR");
            pausarReanudarEmpleado5.setBackground(Color.red);
            pausarReanudarEmpleado5.setForeground(Color.white);

        }
    }//GEN-LAST:event_pausarReanudarEmpleado5MouseClicked

    private void pausarReanudarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pausarReanudarEmpleado1ActionPerformed

    private void pausarReanudarEmpleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarReanudarEmpleado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pausarReanudarEmpleado2ActionPerformed

    public String buzonTexto() {

        String textoBuzon = jTextPane2.getText();

        return textoBuzon;
    }

    public String cantidadBuzon() {

        String cantidadBuzon = jTextPane1.getText();

        return cantidadBuzon;
    }

    public String F1Texto() {

        String furgoneta1 = jTextPane8.getText();

        return furgoneta1;
    }

    public String F2Texto() {

        String furgoneta2 = jTextPane9.getText();

        return furgoneta2;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
                try {
                    Interfaz interfaz = new Interfaz();
                    ObjetoRemoto obj = new ObjetoRemoto(interfaz);
                    Registry registry = LocateRegistry.createRegistry(1099);
                    Naming.rebind("/localhost/PECLIvanWalter", obj);
                } catch (IOException ex) {
                }
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_PausarRenaudarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    private javax.swing.JButton pausarReanudarEmpleado1;
    private javax.swing.JButton pausarReanudarEmpleado2;
    private javax.swing.JButton pausarReanudarEmpleado3;
    private javax.swing.JButton pausarReanudarEmpleado4;
    private javax.swing.JButton pausarReanudarEmpleado5;
    // End of variables declaration//GEN-END:variables
}
