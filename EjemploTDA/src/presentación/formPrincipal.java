/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;
import Pilas.Pila;
import Cola.Cola;
import Lista.clsListaSimple;
import Lista.clsListaDoble;
import Lista.clsListaCircular;

import pArbol.clsArbol;
import java.awt.BasicStroke;
import negocio.nodo;
import negocio.nodoLD;
import negocio.nodoAB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
/**
 *
 * @author pc
 */
public class formPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form formPrincipal
     */
    private Pila objePila;
    private Cola objCola;
    private clsListaSimple objListaS;
    private clsListaDoble objListaD;   
    private clsListaCircular objListac;
    private clsArbol objArbol;
    private int px,py,x0,y0;
    public formPrincipal() {
        initComponents();
        this.objePila = new Pila();
        this.objCola = new Cola();
        this.objListaS = new clsListaSimple();
        this.objListaD = new clsListaDoble();
        this.objListac = new clsListaCircular();
        this.objArbol = new clsArbol();
      
        px = 80;
        py = 100;
        x0=30;
        y0=70;
    }
    
    public void graficarPila(){
           Graphics dibujar = Pn.getGraphics();
        Graphics2D a = (Graphics2D) dibujar;
        a.setStroke(new BasicStroke(3));
        
        dibujar.clearRect(px, py, 300, 400);
        nodo nn = this.objePila.getCima();
        int i = 0;
        dibujar.drawString("Cima->", px-45, py+25);
        while(nn != null){
            String dd = nn.getDato();
            dibujar.setColor(Color.RED);
            dibujar.drawRect(px, py+i*35, 80, 30);
            dibujar.setColor(Color.BLACK);
            dibujar.drawString(dd, px, py+i*35+25);
            i++;
            nn = nn.getRefNodo();
        }
    }
    
    public void graficarCola(){
        Graphics gg = Pn.getGraphics();
        Graphics2D a = (Graphics2D) gg;
        a.setStroke(new BasicStroke(3));
        gg.clearRect(px, py, 600, 300);
        nodo objC = this.objCola.getRefPri();
        gg.setColor(Color.red);
        int i = 0,w=80,h=30,r=10;
        while(objC != null){
            String ss = objC.getDato();
            gg.drawRect(px+i*w, py, w-r, h); // rectángulo
            gg.fillRect(px+(i+1)*w-2*r, py, r, h); // relleno
            gg.drawLine(px+(i+1)*w-r, py+h/2, px+(i+1)*w, py+h/2);
            gg.drawString(ss, px+i*w+5, py+h-5);
            i++;
            objC = objC.getRefNodo();
            if(objC == this.objCola.getRefUlt()){
                gg.setColor(Color.GREEN);
            }else{
                gg.setColor(Color.BLACK);
            } 
        }
    }
    
    public void graficarListaS(){
         Graphics gg = Pn.getGraphics();
        Graphics2D a = (Graphics2D) gg;
        a.setStroke(new BasicStroke(3));
        gg.clearRect(px, py, 1200, 300);
        nodo objL = this.objListaS.getRefPri();
        gg.setColor(Color.red);
        int i = 0,w=80,h=30,r=10;
        while(objL != null){
            String ss = objL.getDato();
            gg.drawRect(px+i*w, py, w-r, h); // rectángulo
            gg.fillRect(px+(i+1)*w-2*r, py, r, h); // relleno
            gg.drawLine(px+(i+1)*w-r, py+h/2, px+(i+1)*w, py+h/2);
            gg.drawString(ss, px+i*w+5, py+h-5);
            i++;
            objL = objL.getRefNodo();
            gg.setColor(Color.BLACK); 
        }
    }
     public void GrafLC(){
        Graphics g = Pn.getGraphics();
        if(this.objListac.getPLC()!=null){
            Graphics2D a = (Graphics2D) g;
            a.setStroke(new BasicStroke(3));
            g.setColor(Color.white);
            g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
            g.setColor(Color.black);
            nodoLD nLCPri = objListac.getPLC();
            int i = 0,b=90,h=49,r=15;
            int X=x0;
            g.setColor(Color.blue);
            g.drawLine(X-r, y0+2*h/3, X-r, y0+4*h/3);
            g.setColor(Color.black);
            g.drawLine(X-r, y0+h/3, X, y0+h/3);
            g.drawLine(X-r, y0+h/3, X-r, y0-h/3);

            do{
                if(nLCPri == this.objListac.getPLC()){
                    g.setColor(Color.green);
                }else g.setColor(Color.black);
                X = x0+i*(b+r);
                String s = ""+nLCPri.getDato();
                g.drawRect(X, y0, b, h);
                g.setColor(Color.blue);
                g.fillRect(X, y0, r+1, h+1);
                g.setColor(Color.black);
                g.fillRect(X+b-r, y0, r+1, h+1);
                g.drawLine(X+b, y0+h/3, X+b+r, y0+h/3);
                g.setColor(Color.blue);
                g.drawLine(X, y0+2*h/3, X-r+2, y0+2*h/3);
                g.setColor(Color.black);
                g.drawString(s, X+20, y0+h/2);
                i++;
                nLCPri = nLCPri.getRefDer();
            }while(nLCPri != this.objListac.getPLC());
            g.drawLine(X+b+r, y0+h/3, X+b+r, y0-h/3);
            g.drawLine(X+b+r, y0-h/3, x0-r, y0-h/3);

            g.setColor(Color.blue);
            g.drawLine(X+b+3, y0+2*h/3, X+b+r, y0+2*h/3);
            g.drawLine(X+b+r, y0+2*h/3, X+b+r, y0+4*h/3);
            g.drawLine(X+b+r, y0+4*h/3, x0-r, y0+4*h/3);
        }else{
            g.setColor(Color.white);
            g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        }
    }
    
    public void graficarListaDoble(){
        Graphics gg = Pn.getGraphics();
        Graphics2D a = (Graphics2D) gg;
        a.setStroke(new BasicStroke(3));
        gg.clearRect(px, py, 1200, 300);
        clsListaDoble objAuxLD = new clsListaDoble();
        objAuxLD.setpListaD(this.objListaD.getpListaD());
        objAuxLD.irPrimero();
        nodoLD nodoLDPri = objAuxLD.getpListaD();
        int i = 0,w=80,h=30,r=10;
        while(nodoLDPri != null){
            if(nodoLDPri == this.objListaD.getpListaD()){
                gg.setColor(Color.green);
            }else{
                gg.setColor(Color.BLACK);
            }
            String ss = ""+nodoLDPri.getDato();
            gg.drawRect(px+i*w, py, w-r, h); // rectángulo
            gg.fillRect(px+(i+1)*w-2*r, py, r, h); // relleno
            gg.setColor(Color.green);
            gg.drawLine(px+(i+1)*w-r, py+h/3, px+(i+1)*w, py+h/3);
            gg.setColor(Color.BLACK);
            gg.drawLine(px+(i+1)*w-r, py+2*h/3, px+(i+1)*w, py+2*h/3);
            gg.drawString(ss, px+i*w+5, py+h-5);
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Codigo = new javax.swing.JTextField();
        txt_detalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Pn = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_Codigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_detalle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Detalle:");

        Pn.setName("pn"); // NOI18N

        javax.swing.GroupLayout PnLayout = new javax.swing.GroupLayout(Pn);
        Pn.setLayout(PnLayout);
        PnLayout.setHorizontalGroup(
            PnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        PnLayout.setVerticalGroup(
            PnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        jMenu1.setText("Menú");

        jMenuItem4.setText("Graficar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pilas");

        jMenuItem1.setText("Insetar Pila");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Sacar dato pila");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Esta vacia");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Colas");

        jMenuItem5.setText("Insertar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Eliminar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Lista Simple");

        jMenuItem7.setText("Insertar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Eliminar Nodo");
        jMenuItem8.setActionCommand("Eliminarnodo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Eliminar por Código");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Lista Doble");

        jMenuItem10.setText("Insertar Izquierda");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Mover Derecha");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Mover Izquierda");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("eliminar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem16.setText("cantida nodos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("lista circular");

        jMenuItem14.setText("Insertar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem15.setText("Eliminar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem19.setText("cant nodos");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Arbol");

        jMenuItem17.setText("Insertar");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem17);

        jMenuItem18.setText("Eliminar");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem18);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(Pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        graficarPila();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objePila.insertar(cod, ss);
        graficarPila();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String ss = this.objePila.sacarDatos();
        JOptionPane.showMessageDialog(this, ss);
        graficarPila();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int dato = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        objCola.insertar(dato, ss);
        graficarCola();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        objCola.eliminar();
        graficarCola();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        String de = txt_detalle.getText();
        this.objListaS.insertarOrdenado(cod, de);
        graficarListaS();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.objListaS.eleminarNodo();
        graficarListaS();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        objListaS.eliminarPorCod(cod);
        graficarListaS();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        int dd = Integer.parseInt(txt_Codigo.getText());
        this.objListaD.insertarIzq(dd);
        graficarListaDoble();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(this.objListaD.moverDer()){
            JOptionPane.showMessageDialog(this, "ok mover Derecha");
            graficarListaDoble();
        }else{
            JOptionPane.showMessageDialog(this, "No de puede mover Der");
        }
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if(this.objListaD.moverIzq()){
            JOptionPane.showMessageDialog(this, "ok mover Izquierda");
            graficarListaDoble();
        }else{
            JOptionPane.showMessageDialog(this, "No de puede mover Izq");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
         int cod=Integer.parseInt(txt_Codigo.getText());
        this.objListac.insertarDerecha(cod);
        GrafLC();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        this.objListaD.Eliminar();
        graficarListaDoble();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        JOptionPane.showMessageDialog(this, "La lista doble tiene "+objListaD.cantNodos()+" nodos.");
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        int cod=Integer.parseInt(txt_Codigo.getText());
        this.objArbol.insertar(cod);
        GrafArbol();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        this.objListac.eliminarDerecha();
        GrafLC();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        JOptionPane.showMessageDialog(this, "La lista circular tiene "+objListac.cantNodos()+" nodos.");
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        this.objArbol.Eliminar(Integer.parseInt(txt_Codigo.getText()));
        GrafArbol();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    public void graficarArbol(){
        Graphics gg = this.getGraphics();
        gg.clearRect(0, 80, 800, 600);
        GrafArbol(this.objArbol.getRaiz(),px,py,300,50);
    }
    
    public void GrafArbol(){
        Graphics G = Pn.getGraphics();
        Graphics2D a = (Graphics2D) G;
        a.setStroke(new BasicStroke(3));
        G.setColor(Color.white);
        G.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        GrafArbol(this.objArbol.getRaiz(),Pn.getWidth()/2,50,100,50);
    }
    public void GrafArbol(nodoAB N,int x,int y,int dx,int dy){
        if(N.getHijoIzq()!=null){
            GrafArbol(N.getHijoIzq(),x-dx,y+dy,(int)(dx*0.6),(int)(dy*0.9));
        }
        GrafNodoAr(N,x,y,dx,dy);
        if(N.getHijoDer()!=null){
            GrafArbol(N.getHijoDer(),x+dx,y+dy,(int)(dx*0.6),(int)(dy*0.9));
        }
    }
    public void GrafNodoAr(nodoAB N,int x, int y,int dx, int dy){
        Graphics G = Pn.getGraphics();
        Graphics2D a = (Graphics2D) G;
        a.setStroke(new BasicStroke(3));
        G.setColor(Color.red);
        G.drawOval(x, y, 40, 40);
        G.drawString(""+N.getCod(), x+10, y+22);
        G.setColor(Color.blue);
        G.drawLine(x, y+15, x-dx, y+dy);
        G.drawLine(x+38, y+15, x+30+dx, y+dy);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_detalle;
    // End of variables declaration//GEN-END:variables
}
