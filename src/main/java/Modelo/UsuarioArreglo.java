/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author OCA-UIE
 */
public class UsuarioArreglo {
    private Usuario arregloU []=new Usuario[5];
    private int tamaño=5;
    private int indice;
    private Usuario usuario;
    public UsuarioArreglo(int tamaño) {
        this.indice = 0;
        this.tamaño=tamaño;
        this.arregloU = new Usuario[tamaño];
    }

    public int getTamaño() {
        return tamaño;
    }

    public UsuarioArreglo() {
        this.indice = 0;

    }
    
    public boolean agregar(Usuario usuario){
        boolean result = false;
        if (!documentoRegistrado(usuario.getTipoDocumento(),  usuario.getDocumento())){
            if(estaLleno()){
               crecerArreglo();
            }
            this.arregloU[this.indice] = usuario;
            this.indice++;
            result= true;
        }
        return result;
    }
    
    public boolean eliminar(Usuario usuario){
        boolean result = false;
        
        return result;
    }
    
    public boolean eliminar(String Paterno){
        boolean result = false;
        for(int i=0;i<tamaño;i++){
            if(arregloU[i].getPaterno().equals(Paterno) && arregloU[i]!=null){
                for(int j=i;j<arregloU.length-1;j++){
                    arregloU[j]=arregloU[j+1];
                }
                this.indice--;
                result=true;
                break;
            }
        }
        return result;
    }
    
    public Usuario getUsuario(String documento){
        Usuario result = null;
        
        return result;
    }
    
    public boolean documentoRegistrado(String tipo,  String documento){
        boolean result = false;
        for(int i=0; i<this.indice; i++ ){
            if(this.arregloU[i]!=null)
            if(this.arregloU[i].getDocumento().equalsIgnoreCase(documento) &&
                    this.arregloU[i].getTipoDocumento().equalsIgnoreCase(tipo)
                    ){
                result = true;
                break;
            }
        }
        return result;
    }
    
    private void crecerArreglo(){
        if(estaLleno()){
            Usuario aux[] =new Usuario [tamaño];
            for(int i=0;i<tamaño;i++){
                aux[i]=arregloU[i];
            }
            arregloU=new Usuario[tamaño+2];
            for(int i=0;i<tamaño;i++){
                arregloU[i]=aux[i];
            }
            indice++;
            tamaño+=2;
            
        }
    }
    
    private boolean estaLleno(){
        boolean result = false;
        if(tamaño==5) result=true;
        return result;
        
    }
    
    private boolean estaVAcio(){
        boolean result = false;
        if(tamaño<5)result=true;
                
        return result;
    }
    
    public void ordenarPorPaterno(){
        //burbuja
        Usuario temporal=new Usuario("","","");
        for(int i=1;i<arregloU.length;i++){
            for(int j=arregloU.length-1;j>=1;j--){
                if(arregloU[j-1].getPaterno().compareTo(arregloU[j].getPaterno())<0){
                    temporal=arregloU[j-1];
                    arregloU[j-1]=arregloU[j];
                    arregloU[j]=temporal;
                }
            }
        }
        
    }
    
    public void ordenarPorMaterno() {
        //insercion directa
        Usuario temp = new Usuario("", "", "");
        int k;
        for (int i = 1; i < arregloU.length; i++) {
            temp = arregloU[i];

            k = i - 1;
            while (k >= 0 && temp.getMaterno().compareTo(arregloU[k].getMaterno()) < 0) {
                arregloU[k + 1] = arregloU[k];
                k--;
            }
            arregloU[k + 1] = temp;
        }

    }
    
    public void ordenarPorDocumento(){
        //seleccion directa
        int i, j, posicion;
        String aux="";
        String menor="";
        Usuario auxiliar=new Usuario(""," ","");

          for (i = 0; i < arregloU.length- 1; i++) {      
                menor = arregloU[i].getDocumento();                                         
                posicion = i;                            
                for (j = i + 1; j < arregloU.length; j++){ 
                      if (arregloU[j].getDocumento().compareTo(menor)<0) {         
                          menor = arregloU[j].getDocumento();        
                          posicion = j;
                      }
                }
                if (posicion != i){        
                    auxiliar=arregloU[i];
                    arregloU[i]=arregloU[posicion];
                    arregloU[posicion]=auxiliar;
                }
          }
    }
    
    
    public Usuario getUser(int i){
        return arregloU[i];
    }
    
    public Usuario[] getArregloU() {
        return arregloU;
    }
    
    public String getpaterno(int i){
        return arregloU[i].getPaterno();
    }
    public String getmaterno(int i){
        return arregloU[i].getMaterno();
    }
    public String getdocumento(int i){
        return arregloU[i].getDocumento();
    }
    public String getnombres(int i){
        return arregloU[i].getNombres();
    }

    public void setPaterno(String paterno, int i){
        arregloU[i].setPaterno(paterno);
    }
    
    public void setMaterno(String materno, int i){
        arregloU[i].setMaterno(materno);
    }
    
    public void setDocumento(String documento, int i){
        arregloU[i].setDocumento(documento);
    }
    
    public void setNombres(String nombres, int i){
        arregloU[i].setNombres(nombres);
    }
    
    @Override
    public String toString() {
        String result="";
        for(int i =0 ; i< this.indice ; i++ ){
            result += this.arregloU[i] + "\n";
        }
        return result;
    }

    
}
