package proyecto.construccion.modelo.vo;
public class Requerimiento1 {
    private String nombre;
    private String primer_Apellido;
    private String segundo_Apellido;
    private Double salario;
    public Requerimiento1(){
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimer_Apellido() {
        return primer_Apellido;
    }
    public void setPrimer_Apellido(String primer_Apellido) {
        this.primer_Apellido = primer_Apellido;
    }
    public String getSegundo_Apellido() {
        return segundo_Apellido;
    }
    public void setSegundo_Apellido(String segundo_Apellido) {
        this.segundo_Apellido = segundo_Apellido;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}