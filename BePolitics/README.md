iw
==

Proyecto-plantilla para Ingeniería Web UCM, curso 2015-16

## Requisitos y dependencias

Este proyecto está pensado para ejecutarse sobre [Spring STS v3.6.1](https://spring.io/tools/sts/legacy). Probablemente funcione bien con versiones posteriores.

La plantilla rompe con la de un Spring MVC Proyect tradicional, y en su lugar usa [Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started) para 
- simplificar mucho la gestión de dependencias en el pom.xml
- permitir empaquetar la aplicación para uso sin servidor externo (vía `mvn clean package && java -jar target/iw-1.0.0-BUILD-SNAPSHOT.war`); es decir, genera `war` con tomcat embebido.
- simplificar mucho la configuración del acceso a BD (único fichero: `application.properties`)
- mejorar seguridad

## Uso

Puedes lanzarla de 3 formas:
- desde línea de comandos: `mvn clean package && java -jar target/iw-1.0.0-BUILD-SNAPSHOT.war`
- desde STS con el servidor embebido, vía `Run As > Spring Boot`
- desde STS con el servidor de STS, vía `Run As > Web app` (podrás cambiar JSPs, Controladores sin recargar)

Es fácil lanzar pruebas unitarias con `mvn test`:
- [sobre el controlador](https://github.com/manuel-freire/iw/blob/master/src/test/java/es/fdi/iw/model/SpringBootLauncherTests.java)
- [sobre la BD y objetos del modelo](https://github.com/manuel-freire/iw/blob/master/src/test/java/es/fdi/iw/model/UserTest.java)

Incluye un sistema de login relativamente seguro (aunque tendrás que verificar roles en la sesión / proteger contra CSRF manualmente).

## Incorporando la plantilla a un proyecto Spring MVC estándar

Descarga la plantilla usando git desde una línea de comandos:

     git clone https://github.com/manuel-freire/iw.git
     
Esto la descargará a una carpeta `iw`.

Asumiremos que estás en una carpeta en la que tienes `viejo` (tu código que no usa esta plantilla) e `iw` (la plantilla). Asumo que la estructura de paquetes es similar en ambos (`es.fdi.iw`) - modifica los comandos si no es así.
- cierra el STS, y borra sus ficheros (luego los regenerarás): `rm -rf viejo/.settings viejo/.classpath viejo/.project`
- copia los ficheros esenciales de la plantilla a tu proyecto `cp iw/pom.xml viejo && cp iw/src/main/webapp/WEB-INF/web.xml viejo/src/main/webapp/WEB-INF/ && cp -r iw/src/main/java/es/fdi/iw/*.java viejo/src/main/java/es/fdi/iw`
- modifica el `name` y el `artifactId` de tu proyecto editando tu pom.xml (están [en las líneas 6 y 7 ](https://github.com/manuel-freire/iw/blob/master/pom.xml#L6)), de forma que coincidan con el nombre que has elegido.
- mueve tu controlador de sitio: tiene que estar en un subpaquete de `es.fdi.iw`; recomiendo `es.fdi.iw.controller`
- ya puedes importar el proyecto en STS como un `maven project`.
- usa `meld` para incorporar aspectos del controlador de la plantilla en tu propio controlador: `meld iw viejo`; o pruebas unitarias, o lo que veas oportuno.
- modifica las clases del modelo (`es.fdi.iw.model`) a tu gusto

## Erratas y comentarios

Abre _issues_ si quieres que añada cosas concretas o ves errores; sube _pull requests_ si se te ocurre cómo añadirlas/solucionarlos (sube nota!).

# BePolitics, anotaciones sobre el modelo

# INDICACIONES SOBRE GITHUB
# {
-Aquí tenéis el programa, por si os interesa

-https://desktop.github.com/

-Y una microguía

-https://rogerdudler.github.io/git-guide/index.es.html

-El cliente propio de github está para win y mac, lo siento Bea, vas a tener que buscar tu propia interfaz gráfica

-No es muy diferente de sourcetree pero es infinitamente más fácil

-Si queréis currar, haced una nueva rama, la modificáis y luego se hace un merge

# }

# GUíA DE FUNCIONAMIENTO DE GITHUB
# {
-Para cuando queráis usar git os indico:

-SIEMPRE CREÁIS UNA RAMA NUEVA y la llamáis como os salga del potorro

-trabajáis en esa rama normal y hacéis al final un commit a la propia rama (no a la rama master)

-tras eso, buscáis el "pull request" y lo lanzáis. en github aparece el pull request

-hay dos opciones:

1.-No hay conflitco, cojonudo, se acepta el pull y punto
 
2.-Hay conflicto, alguien ha tocado el mismo archivo y hay cruce de versiones, hay que hacer merge manual

-Tras hacer el pull la rama master es la oficial, y en ella estará todo
    
# }

# AGOBIOS DE ISMAEL
# {
-Del modelo queda mazo y el tiempo empieza a apremiar. De STS también queda mazo

-Dijo el Manuel que antes de vacaciones pondría una entrega...

-Y queda esta semana

-y no os veo hacer pulls al código

-Por falta de tiempo no estoy probando NADA 

-Osea que cuando entremos al turrón lo mismo nos encontramos con una nube de bugs

-Lo suyo es que alguien fuera detrás de mí probando lo que he programado

-El modelo tiene un curro de la hostia, estoy usando cloc (un ejecutable externo) para contar líneas de código y hay ya 830 líneas de código, 185 líneas en blanco y 420 líneas de comentarios en 24 archivos y esta mierda no avanza. Ya no sé ni qué está hecho y qué no

# }

# COSAS QUE SEGURAMENTE HAYA QUE HACER
# {
-Lo más seguro es que la base de datos haya que reformarla, porque no sé si va a valer con el programa, por diseño he cambiado un par de cosas y eso tiene que estar reflejado

-Va a haber que hacer clases que permitan la carga desde la base de datos

-Estoy haciendo los recursos en "int" y casi seguro que es mejor en double, porque los modificadores y eso, mejor fraccionarios...

-Casi seguro que en construcciones nos van a hacer falta más getters

# }

# COSAS SOBRE LA APLICACION
# {
-He añadido bastante documentación a todo por si os diera por trabajar en ello algún día, que veáis qué mierdas hace cada cosa. 
He guardado el formato de javadoc para que si llamáis a un método mío, os invoque el javadoc en el compilador como 
con la api estándar de Java

# }

# COSAS HECHAS(No es seguro que estén completas, hay que darle una vuelta)
# {
-[Ismael = **(I)**, Bea = **(B)**, Julia = **(J)**, Sehed = **(S)**]

-ModificadorProduccion **(I)** //No su uso, sino el propio modificador

-TipoRecurso **(I)** 

-Recursos **(I)**

-Construcciones **(I)**

-TipoConstruccion **(I)**

-Pair **(I[tomado de un australiano y citada la fuente])** //UNa clase que he pillado

-ExceptionPolitico **(I)**

-Politico **(I)**

-StatsPolitico **(I)**

# }

# COSAS EMPEZADAS
# {
-Guerras **(I)** //Lleva bastante

-Paises **(I)** //Empezado, muy poco

-ComunidadEconomica **(I)** //Ni recuerdo cuánto lleva

-Genero **(I)** //Los tres siguientes no sé si habrá que añadirles métodos o como enumerados simples valen

-Rol **(I)**

-TipoLider **(I)**

-Usuario **(J)** //Creados constructores y getters y setters de los atributos que creo necesarios 


# }

# COSAS QUE HAY QUE HACER DESDE CERO
# {
  
 -EventoComunidadEconomica
 
 -EventoRegular
 
 -EvengoGuerra
 
 -Mercado
 
# }

