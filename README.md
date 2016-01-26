# ModeloBePolitics, el modelo para la aplicación


# Lanzar servidor de BD
- chmod 0755 hsqldb.sh 
- ./hsqldb.sh start
- ./hsqldb.sh gui
- ./hsqldb.sh --help
- ls -l /tmp/iwdb


# COSAS QUE SEGURAMENTE HAYA QUE HACER
# {

-Estoy haciendo los recursos en "int" y casi seguro que es mejor en double, porque los modificadores y eso, mejor fraccionarios...

# }

# COSAS SOBRE LA APLICACION
# {
-Cada clase está muy bien documentada
-Hay que guardar el formato Javascript

# }

# COSAS EMPEZADAS
# {

-Usuario 

# }

# COSAS QUE HAY QUE HACER DESDE CERO
# {
 
 -Mercado
 
 -Cookies
 
 -Sesión de usuario
 
 -login
 
# }


# COSAS HECHAS(No es seguro que estén completas, hay que darle una vuelta)
# {

-ModificadorProduccion //No su uso, sino el propio modificador

-TipoRecurso

-Recursos 

-Construcciones 

-TipoConstruccion 

-Pair 

-ExceptionPolitico

-Politico

-StatsPolitico

-Evento

-Guerras

-Paises

-ComunidadEconomica 

-Genero

-Rol 

-TipoLider
# }




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
