package pe.edu.cibertec.spring.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

@ComponentScan(basePackages = "pe.edu.cibertec.spring.base")
//Si no se agrega la anotación @EnableAspectJAutoProxy
//no se podrán usar los aspectos en la aplicación
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class PrincipalSpringAnotacion {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(
                PrincipalSpringAnotacion.class)) {

            UsuarioServicio usuarioServicio = ctx.getBean(UsuarioServicio.class);
            Usuario usuario = new Usuario();
            usuario.setCorreoElectronico("usuario@gmail.com");
            usuario.setContrasena("123456");
            usuario.setNombre("usuario");
            usuarioServicio.guardar(usuario);

            Usuario otroUsuario = usuarioServicio.obtenerPorCorreoElectronico(usuario.getCorreoElectronico());
            System.out.println(otroUsuario.getNombre());
        }
    }
}
