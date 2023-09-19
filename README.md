# TFG

En este repositorio voy a ir desarrollando mi trabajo fin de grado de ingeniería de la ciberseguridad. Este proyecto va a consistir en resolver el problema del "α-separator Problem".

El enunciado del problema es el siguiente:

La mayoría de las infraestructuras críticas se pueden modelar fácilmente como una red de nodos interconectados entre ellas. Si uno o más nodos de la red fallan, la conectividad de la red puede verse comprometida, hasta el punto de desconectar completamente la red. Además, desconectar la red puede provocar fallas en cascada, porque los nodos restantes pueden sobrecargarse debido al tráfico pesado en la red. Uno de los objetivos principales de un atacante es aislar los nodos cuya eliminación desconecta la red en subred de tamaño mínimo. Por el contrario, un defensor debe identificar esos puntos débiles para mantener la integridad de la red. Este trabajo se centra en resolver el α problema del separador, cuyo objetivo principal es encontrar un conjunto mínimo de nodos que desconecten una red en subred aisladas de tamaño menor que un valor dado. El problema se aborda desde un punto de vista metaheurístico, analizando las soluciones dadas por un procedimiento de búsqueda adaptativa aleatoria codiciosa sobre diferentes topologías de red. Los resultados obtenidos se comparan con el mejor algoritmo encontrado en la literatura.

RESTRICCIONES DEL PROBLEMA --> el número máximo de nodos por cada componente conexa debe ser α * n, siendo n el número de nodos total del grafo.

Enlace del problema --> https://link.springer.com/chapter/10.1007/978-3-030-03496-2_37


En la primera fase, vamos a resolverlo escogiendo los nodos al azar. Para ello, vamos a usar la clase Random, que nos generará un entero random del 0 hasta n-1 siendo n el numero de nodos del grafo. La estructura que hemos utilizado, es un conjunto de conjuntos: 

(Set<Integer> grafo[] = new Set[numeroNodos]);

La estrucura que hemos seguido para la resolucion es la siguiente:

-copia del grafo, para no tocar el primero
-crear un set<Integer> solucion;

WHILE TODAS LAS COMPONENTES CONEXAS NO TENGAN MENOS DE N NODOS HACER:

- elegir nodo random
- eliminarlo
- contar el número de nodos de cada componente conexa
