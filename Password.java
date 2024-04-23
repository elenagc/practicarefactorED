package Seguridad;
/* 
 * @Author Sergio Oyola Márquez
 * @Version 1.1
 */

public class Password {

	//Constantes
	  
    /**
     * Longitud por defecto
     */
    private final static int LONG_DEF=8;
  
    //Atributos
  
    /**
     * Longitud de la contraseÃ±a
     */
    private int longitud;
    /**
     * caracteres de la contraseÃ±a
     */
    private String longitudcontrasenya;
  
    //Metodos publicos
  
    /**
     * Devuelve la longitud
     * @return longitud de la contraseÃ±a
     */
    public int getLongitud() {
        return longitud;
    }
  
    /**
     * Modifica la longitud de la contraseÃ±a
     * @param longitud a cambiar
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
  
    /**
     * Devuelve la contraseÃ±a
     * @return contraseÃ±a
     */
    public String getContrasena() {
        return longitudcontrasenya;
    }
  
    /**
     * Genera una contraseÃ±a al azar con la longitud que este definida
     * @return contraseÃ±a
     */
    public String generaPassword (){
        String password="";
        for (int i=0;i<longitud;i++){
            //Generamos un numero aleatorio, segun este elige si aÃ±adir una minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
                char minusculas= generarMinuscula();
                password+=minusculas;
            }else{
                if(eleccion==2){
                    char mayusculas=generarMayuscula();
                    password+=mayusculas;
                }else{
                    char numeros=generarNumero();
                    password+=numeros;
                }
            }
        }
        return password;
    }
  
    /**
     * Comprueba la fortaleza de la contraseÃ±a
     * @return
     */
    public boolean esFuerte(){
        int cuentanumeros=0;
        int cuentaminusculas=0;
        int cuentamayusculas=0;
        //Vamos caracter a caracter y comprobamos que tipo de caracter es
        for (int i=0;i<longitudcontrasenya.length();i++){
                if (longitudcontrasenya.charAt(i)>=97 && longitudcontrasenya.charAt(i)<=122){
                    cuentaminusculas+=1;
                }else{
                    if (longitudcontrasenya.charAt(i)>=65 && longitudcontrasenya.charAt(i)<=90){
                        cuentamayusculas+=1;
                }else{
                    cuentanumeros+=1;
                    }
                }
            }
            //Si la constraseÃ±a tiene mas de 5 numeros, mas de 1 minuscula y mas de 2 mayusculas
            if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
            return true;
        }else{
            return false;
        }
    }
  
    //Constructores
    /**
     * Crea una contraseÃ±a al azar
     */
    public Password (){
        this(LONG_DEF);
    }
  
    /**
     * La contrasena sera la pasada por parametro
     * @param longitud
     */
    public Password (int longitud){
        this.longitud=longitud;
        longitudcontrasenya=generaPassword();
    }
    public static char generarMinuscula() {
        return (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
    }

    public static char generarMayuscula() {
        return (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
    }

    public static char generarNumero() {
        return (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
    }
}
