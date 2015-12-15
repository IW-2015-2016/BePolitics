# ModeloBePolitics, el modelo para la aplicación

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

# }

# COSAS QUE HAY QUE HACER DESDE CERO
# {
 -Usuario //Está pero hay que borrarla
 
 -EventoComunidadEconomica
 
 -EventoRegular
 
 -EvengoGuerra
 
 -Mercado
 
# }
