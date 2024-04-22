/**
 * Práctica Refactor
 * @author Iván Ruiz Carrascal
 * @version 1.1
 */

package refactor.seguridad;


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
    private int longitudcontrasenya;
    /**
     * caracteres de la contraseÃ±a
     */
    private String contrasenya;

    //Metodos publicos

    /**
     * Devuelve la longitud
     * @return longitud de la contraseÃ±a
     */
    public int getLongitudcontrasenya() {
        return longitudcontrasenya;
    }

    /**
     * Modifica la longitud de la contraseÃ±a
     * @param longitudcontrasenya a cambiar
     */
    public void setLongitudcontrasenya(int longitudcontrasenya) {
        this.longitudcontrasenya = longitudcontrasenya;
    }

    /**
     * Devuelve la contraseÃ±a
     * @return contraseÃ±a
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Genera una contraseÃ±a al azar con la longitud que este definida
     * @return contraseÃ±a
     */
    public String generaPassword (){
        String password="";
        for (int i = 0; i< longitudcontrasenya; i++){
            //Generamos un numero aleatorio, segun este elige si aÃ±adir una minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));

            if (eleccion==1){
                password = generaMinusculas(password);
            }else{
                if(eleccion==2){
                    password = generaMayusculas(password);
                }else{
                    password = generaNumeros(password);
                }
            }
        }
        return password;
    }


    public String generaMinusculas(String passwd){
        char minusculas = (char) ((int)Math.floor(Math.random()*(123-97)+97));
        passwd += minusculas;
        return passwd;
    }

    public String generaMayusculas(String passwd){
        char mayusculas=(char)((int)Math.floor(Math.random()*(91-65)+65));
        passwd+=mayusculas;
        return passwd;
    }

    public String generaNumeros(String passwd){
        char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
        passwd+=numeros;
        return passwd;
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
        for (int i = 0; i< contrasenya.length(); i++){
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
     * @param longitudcontrasenya
     */
    public Password (int longitudcontrasenya){
        this.longitudcontrasenya = longitudcontrasenya;
        contrasenya =generaPassword();
    }

}
