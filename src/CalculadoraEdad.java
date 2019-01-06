
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jhonny Pindo
 */
public class CalculadoraEdad {

    public static void main(String[] args) {
        int edad;
        int añoN;
        
       
        edad=calcular(new GregorianCalendar(1994, 02, 14));
        JOptionPane.showMessageDialog(null, "archivo edad.txt\n" +"GUARDADO CORRECTAMENTE");
        escribir("edad.txt",edad);
        

    }

    public static int calcular(Calendar fechaNac) {
        Calendar fechaActual = Calendar.getInstance();
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        if (months < 0 || (months == 0 && days < 0)) {
            years--;
        }
        return years;
    }
    public static void escribir(String nombre, int edad){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        try{
            f=new File(nombre);
            w=new FileWriter(f);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);
            wr.write("su edad es:");
            wr.append(""+edad+ " años");
            wr.close();
            bw.close();
            
        }catch (Exception E){
            JOptionPane.showMessageDialog(null, "ha sucuedido un error");
        }
    }
    
}
