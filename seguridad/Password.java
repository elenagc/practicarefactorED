package refactor;

/**
 * Autor: Airan
 * Versión: 1.1
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
    private int longitudcontraseya;
    /**
     * caracteres de la contraseÃ±a
     */
    private String contrasena;
  
    //Metodos publicos
  
    /**
     * Devuelve la longitud
     * @return longitud de la contraseÃ±a
     */
    public int getLongitudcontraseya() {
        return longitudcontraseya;
    }
  
    /**
     * Modifica la longitud de la contraseÃ±a
     * @param longitudcontraseya a cambiar
     */
    public void setLongitudcontraseya(int longitudcontraseya) {
        this.longitudcontraseya = longitudcontraseya;
    }
  
    /**
     * Devuelve la contraseÃ±a
     * @return contraseÃ±a
     */
    public String getContrasena() {
        return contrasena;
    }
  
    /**
     * Genera una contraseÃ±a al azar con la longitud que este definida
     * @return contraseÃ±a
     */
    public String generaPassword (){
        String password="";
        for (int i = 0; i< longitudcontraseya; i++){
            //Generamos un numero aleatorio, segun este elige si aÃ±adir una minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
                password = generarMinusculas(123, 97, password);
            }else{
                if(eleccion==2){
                    password = generarMayusculas(91, 65, password);
                }else{
                    password = generarMayusculas(58, 48, password);
                }
            }
        }
        return password;
    }

    private static String generarMayusculas(int x, int x1, String password) {
        char mayusculas = (char) ((int) Math.floor(Math.random() * (x - x1) + x1));
        password += mayusculas;
        return password;
    }

    private static String generarMinusculas(int x, int x1, String password) {
        char minusculas = (char) ((int) Math.floor(Math.random() * (x - x1) + x1));
        password += minusculas;
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
        for (int i=0;i<contrasena.length();i++){
                if (contrasena.charAt(i)>=97 && contrasena.charAt(i)<=122){
                    cuentaminusculas+=1;
                }else{
                    if (contrasena.charAt(i)>=65 && contrasena.charAt(i)<=90){
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
     * @param longitudcontraseya
     */
    public Password (int longitudcontraseya){
        this.longitudcontraseya = longitudcontraseya;
        contrasena=generaPassword();
    }

}
