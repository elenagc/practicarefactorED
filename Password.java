
/**
 * Autor: [Mykhaylo Freyishyn Novychenko]
 * Versión: 1.1
 */

package seguridad;

public class Password {
	//Constantes
	  
    /**
     * Longitud por defecto
     */
    private final static int LONG_DEF=8;
  
    //Atributos
  
    /**
     * Longitud de la contrasenya
     */
    private int longitudcontrasenya;
    /**
     * caracteres de la contrasenya
     */
    private String contrasenya;
  
    //Metodos publicos
  
    /**
     * Devuelve la longitud
     * @return longitud de la contrasenya
     */
    public int getLongitud() {
        return longitudcontrasenya;
    }
  
    /**
     * Modifica la longitud de la contrasenya
     * @param longitud a cambiar
     */
    public void setLongitudContrasenya(int longitud) {
        this.longitudcontrasenya = longitud;
    }
  
    /**
     * Devuelve la contrasenya
     * @return contrasenya
     */
    public String getcontrasenya() {
        return contrasenya;
    }
  
    /**
     * Genera una contrasenya al azar con la longitud que este definida
     * @return contrasenya
     */
    public String generaPassword (){
        String password="";
        for (int i=0;i<longitudcontrasenya;i++){
            //Generamos un numero aleatorio, segun este elige si aniadir una minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
                password += generaMinuscula();
            }else{
                if(eleccion==2){
                    password += generaMayuscula();
                }else{
                    char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
                    password += generaNumero();
                }
            }
        }
        return password;
    }
    
    
    /**
     * Genera caracteres minúscula al azar
     * 
     * @return 
     */
    private char generaMinuscula() {
    	return (char)((int)Math.floor(Math.random() * (123-97) + 97 ));
    }
    
    /**
     * Genera caracteres mayúscula al azara
     * 
     * @return
     */
    private char generaMayuscula() {
    	return (char)((int)Math.floor(Math.random() * (91-65) + 65));
    }
    
    /**
     * Genera número al azar
     * 
     * @return
     */
    private char generaNumero() {
    	return (char)((int)Math.floor(Math.random() * (58-48) + 48));
    }
  
    
    /**
     * Comprueba la fortaleza de la contrasenya
     * @return
     */
    public boolean esFuerte(){
        int cuentanumeros=0;
        int cuentaminusculas=0;
        int cuentamayusculas=0;
        //Vamos caracter a caracter y comprobamos que tipo de caracter es
        for (int i=0;i<contrasenya.length();i++){
                if (contrasenya.charAt(i)>=97 && contrasenya.charAt(i)<=122){
                    cuentaminusculas+=1;
                }else{
                    if (contrasenya.charAt(i)>=65 && contrasenya.charAt(i)<=90){
                        cuentamayusculas+=1;
                }else{
                    cuentanumeros+=1;
                    }
                }
            }
            //Si la contrasenya tiene mas de 5 numeros, mas de 1 minuscula y mas de 2 mayusculas
            if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
            return true;
        }else{
            return false;
        }
    }
  
    
    //Constructores
    /**
     * Crea una contrasenya al azar
     */
    public Password (){
        this(LONG_DEF);
    }
  
    /**
     * La contrasenya sera la pasada por parametro
     * @param longitud
     */
    public Password (int longitud){
        this.longitudcontrasenya=longitud;
        contrasenya=generaPassword();
    }
}
