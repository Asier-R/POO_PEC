**Sistema Integrado de Gestión de un Hospital Universitario**

Práctica de la asignatura Programación Orientada a Objetos Escenario para el curso 2023-2024 - febrero de 2024 - Versión 1.1

Departamento de Lenguajes y Sistemas Informáticos, Escuela Técnica Superior de Ingeniería Informática, UNED

1. **Introducción** 

Los objetivos que se plantean en la realización de esta práctica son los siguientes: 

- Familiarización con la Programación Orientada a Objetos (POO): definición de clases e instancias, uso de la herencia, definición/uso de métodos estáticos y abstractos. 
- Realización del diseño orientado a objetos de un problema. 
- Implementación de un programa sencillo donde se manejen conceptos relacionados con POO. 

La práctica se va a implementar en Java 2 Estándar Edition (J2SE). El compilador de Java que se usará será BlueJ, tal y como se define en el programa de la asignatura. 

2. **Programación Orientada a Objetos en Java** 

El paradigma de programación orientada a objetos define un programa como una colección de entidades  que  se  relacionan  para  resolver  un  problema.  Estas  entidades,  que  se  conocen genéricamente como objetos, están definidas por un conjunto de propiedades y métodos, y están organizadas en torno a una jerarquía de clases. 

En Java cada objeto puede tener variables y métodos privados y públicos. Se puede modificar dicha visibilidad de una clase usando los modificadores de acceso a miembros. Las dos maneras más habituales de especificar la accesibilidad son: 

private – la variable o método está disponible solamente para esta clase,  public – la variable o método está disponible para todas las clases,

Una clase puede heredar los variables y métodos públicos de otra clase a través del mecanismo de herencia y la palabra clave extends. Por ejemplo: 

//clase base que va a contener información sobre vehículos de nuestra empresa: **public** vehiculo { 

**private  int**  noPuertas; 

**private  int**  noRuedas; 

**private**  String  modelo; 

**public** vehiculo(){} 

**public  void**  setNoPuertas(**int**  np)  { 

noPuertas = np; 

} 

//etc. 

} 

//una clase para tratar a los coches en general... **public** coche **extends** vehiculo { 

**private  boolean**  airbags; 

**public** coche(){} 

**public  void**  setAirbags(Boolean  a)  { 

airbags = a; 

} 

//etc. 

} 

//y, por fin, una clase para tratar a los coches deportivos **public final** cocheDeportivo **extends** vehículo { 

**private** String capacidadMotor; 

**private  int**  maxVelocidad; 

**public** cocheDeportivo(){} 

**public  void**  setCapacidadMotor(String  cm)  { 

capacidadMotor = cm; 

} 

//etc. 

//se puede llamar a cualquier método en las superclases como //si estuvieran dentro 

//de  esta  misma  clase,  p.ej.: 

setNoPuertas(2); 

} 

**Notas:** Las clases que extienden otras clases tienen el nombre de subclases y las clases que son extendidas por otras clases tienen el nombre de superclases. 

Hay que tener cuidado a la hora de planificar las relaciones de herencia entre clases en Java porque una clase solamente puede heredar variables y métodos de otra (y sus superclases). Es decir, que no hay herencia múltiple en Java como hay en lenguajes como C++ (aunque se puede reproducir la técnica de herencia múltiple usando interfaces…). De todas formas, la manera más habitual para tratar este tema es simplemente usar una clase dentro de otra, por ejemplo, si hay una clase para el aparcamiento de una empresa que ya es una extensión de una clase base aparcamiento, dicha clase no puede heredar ninguna otra clase, por lo tanto, se incluirán las clases de coches, camiones, motos, etc., así: 

**public** aparcamientoEmpresa **extends** aparcamiento { 

**private** String nombreEmpresa; 

**private** cocheDirector = **new** cocheDeportivo(…); 

**public** aparcamientoEmpresa(){} 

//etc. 

//para llamar a algún método en una clase hay que especificar //la  variable  de  la  instancia… cocheDirector.setCapacidadMotor(“4.5l”); 

} 

3. **Descripción de la práctica** 

Según el diccionario de la RAE, un hospital es  

“Establecimiento destinado al diagnóstico y tratamiento de enfermos, donde a menudo se practican la investigación y la docencia.” 

Siguiendo esta definición, cualquier hospital ofrece un amplio rango de servicios relacionados con la salud. Para que funcione de una forma eficaz y eficiente hace falta la labor coordinada de profesionales de muchos campos, más allá del puramente médico, vinculados con un amplio número de zz_recursos variados  (inmuebles,  productos  farmacéuticos,  aparatos  tecnológicos,  productos  de  limpieza, comidas, etc.), que proporcionan a los pacientes puntuales, o a los que están ingresados, un servicio apropiado y de calidad. Cualquier error o ineficiencia en el proceso de gestión de los componentes de un hospital puede resultar en problemas, retrasos y, en casos extremos, daños de salud. 

Tal y como indica la definición, una parte importante de la consolidación futura de un hospital es la formación de la próxima generación de miembros del personal médico y otros especialistas. Por ello, hoy en día, la gran mayoría de hospitales tienen convenios de formación con las universidades que permiten que estudiantes del campo de la salud puedan realizar sus prácticas en el hospital y recibir formación por parte de especialistas en Medicina y otras especialidades sanitarias. 

La práctica de este año consiste en diseñar y desarrollar un sistema de gestión integrado de un hospital universitario para lograr la necesaria coordinación. A continuación, se detallarán las diferentes partes del hospital que tienen que estar representadas en el sistema junto con las personas y los zz_recursos que se encuentran allí y las funciones que desempeñan.  

1. **Campus del hospital** 

El hospital está compuesto por un conjunto de unidades que se pueden clasificar de la siguiente forma: **Administración** 

Aquí se agrupan los servicios no médicos del hospital, incluyendo dirección, documentación clínica y archivo, contabilidad y facturación, zz_recursos humanos, mantenimiento, limpieza y seguridad. 

**Consultas externas** 

Las consultas son para pacientes que acuden con cita previa para recibir atención de especialistas en primera consulta o revisión de un miembro del personal de enfermería para un tratamiento prescrito previamente.  También podrían acudir a Fisioterapia para problemas musculares. En realidad, un hospital puede disponer de muchísimas especialidades, pero en esta práctica se van a contemplar solamente las siguientes: Aparato Digestivo, Cardiología, Cirugía General, Dermatología, Medicina Interna, Oncología, Oftalmología, Psiquiatría y Traumatología. 

**Unidad de Cuidados Intensivos (UCI)** 

Un área para pacientes (tanto adultos, niños y neonatos) que requieren un tratamiento médico especializado bajo una supervisión de 24 horas. 

**Hospitalización** 

El hospital de esta práctica dispone de 90 habitaciones individuales para tratamiento y recuperación de enfermedades de diversa índole o intervenciones quirúrgicas que no requieran un seguimiento como el facilitado en una UCI. Una vez que un miembro del personal médico de consultas externas o de urgencias ha indicado que un paciente tiene que estar ingresado, y la administración ha encontrado un hueco en el calendario para que haya una habitación disponible, junto con acceso a las especialistas y zz_recursos necesarios (p.ej., acceso a un quirófano, cirujano, anestesista), se avisa al paciente y puede rellenar la documentación necesaria, pagar si procede y ser conducido a su habitación. 

**Pruebas médicas** 

Hoy en día la tecnología juega un papel muy importante en el diagnóstico y tratamiento de muchas enfermedades. Para esta práctica se contemplan solamente los siguientes tipos de pruebas: analíticas,     rayos X, resonancia magnética y ecografía. 

**Unidades médicas especializadas** 

Hay actualmente algunos problemas de salud comunes a un gran número de personas. Dada la importancia de estos problemas en la sociedad en general, es muy común que un hospital agrupe en unidades médicas especializadas tanto a los miembros del personal médico como los miembros de enfermería expertos en estas áreas específicas. Para esta práctica se van a contemplar solamente las siguientes: enfermedades cardiovasculares y diabetes. Tanto los pacientes que vienen a consultas externas como los que están hospitalizados pueden recibir tratamiento en una de estas unidades. 

**Urgencias** 

Las  personas  acuden  a  urgencias  cuando  el  plazo  de  comienzo  del  tratamiento  es  esencial.  Los ejemplos incluyen a personas que han sufrido accidentes, cambios inesperados en su estado de salud,      etc. Después de una valoración inicial, y un tratamiento si procede, el paciente puede volver a casa con indicaciones como pedir cita a un especialista en consultas externas o puede quedar ingresado para un tratamiento más inmediato. 

**Unidad de formación** 

Dada la relación entre el hospital y las universidades cercanas, donde hay convenios de colaboración, es necesaria una unidad donde los especialistas pueden proporcionar formación universitaria en programas de posgrado. En esta unidad hay clases y laboratorios para estas actividades. Aparte de esta unidad, los estudiantes pueden hacer seguimiento con los miembros del personal médico/los miembros del personal de enfermería mientras tratan a sus pacientes. 

**Cafetería** 

Esta unidad proporciona comidas y bebidas 24 horas al día, tanto a profesionales del hospital como a      pacientes y sus familias. 

**Aparcamiento** 

Dado el gran número de personas en permanente trasiego dentro del hospital todos los días, es necesario un aparcamiento multinivel que, aunque se gestione a través de un sistema automático de tickets, disponga de personal para coordinar su funcionamiento y resolver incidencias que ocurran a lo largo del día. 

El  funcionamiento  del  hospital  y  las  unidades  que  componen  su  campus  se  lleva  a  cabo  por especialistas que trabajan en las siguientes áreas de salud que se detallan a continuación, simplificadas para esta práctica. 

2. **Personal sanitario, de administración, de servicios y sus funciones** 

**Gerencia y servicios generales:** 

- Gestión de personal del hospital (altas, bajas, modificaciones de expedientes). 
- Asignación de un miembro del personal médico a cada unidad según su especialidad para trabajar en turno de mañana o de tarde. Por la noche solamente hay personal médico en urgencias.  
- Gestión de pacientes (altas, bajas, modificaciones de expedientes, historial médico, dar citas presenciales y por teléfono para ver a un miembro del personal médico/un miembro del personal de enfermería en consultas externas o unidades especializadas, o para una prueba médica). 
- Admisión de pacientes para la hospitalización (entrada y salida de pacientes). 
- Gestión contable (pago de nóminas, facturas para zz_recursos y servicios prestados al hospital, preparación y emisión de facturas). 
- Gestión  de  servicios  de  mantenimiento  (alta  y  baja  de  zz_recursos  dañados  que  requieren mantenimiento o reparación y asignación de cada caso a un técnico). 
- Gestión de otros servicios del hospital como limpieza, cafetería, aparcamiento, seguridad (asignación del personal especializado a la unidad en cuestión, turno de mañana y turno de tarde). 

**Servicio de Medicina****      

- Consulta de un paciente a un miembro del personal médico (puede tener lugar en consultas externas, unidades especializadas o con pacientes ingresados). El personal médico hace un diagnóstico, para identificar la enfermedad o problema de salud, puede ordenar pruebas médicas al paciente, prescribe medicamentos e indica los siguientes pasos en el tratamiento. Se graban todos los datos generados durante la consulta en el expediente del paciente y se proporciona una copia impresa a éste de su informe. 
- En todas las unidades, menos urgencias, cada miembro del personal médico empieza su turno de trabajo con una lista temporizada de pacientes que tiene que ver. En urgencias, el personal médico atiende a los pacientes, según su orden de llegada. 

**Servicios de Enfermería** 

- Los  miembros  del  personal  de  enfermería  trabajan  en  todas  las  unidades,  siguiendo  las indicaciones del expediente médico de cada paciente o las instrucciones dadas directamente por un miembro del personal médico.  
- Los miembros de enfermería tienen una lista de pacientes que tienen que ver, al igual que los miembros de personal médico, y tienen que actualizar el expediente médico de cada paciente una vez terminado su tratamiento. 

**Servicios de soporte al hospital** 

- Aquí están agrupados los servicios auxiliares no médicos pero esenciales para el correcto funcionamiento del hospital. En esta práctica, solamente hace falta la asignación de dichas personas a las diferentes funciones (por parte de gerencia) y un historial de la actividad de cada trabajador cada día, en su turno de mañana o tarde, como se indica a continuación: 
- Servicio de mantenimiento: empieza su turno de trabajo con una lista de actividades de reparación y mantenimiento que hay que realizar y, cada vez que termina un trabajo, puede marcarlo como terminado junto con un breve informe de lo que se ha hecho. 
- Servicios de seguridad: empieza cada turno con indicaciones de dónde van a trabajar y, para cada fecha y turno, dejan constancia en el sistema de cualquier problema que haya       ocurrido. 
- Hay dos servicios que forman parte del sistema de gestión como trabajadores del hospital y, para esta práctica, no interaccionan con el sistema: servicios de cafetería y servicios del aparcamiento. 
4. **Desarrollo de la práctica** 

Para la realización de esta práctica un alumno NO necesita disponer de conocimientos médicos ni entender los detalles de cada especialidad médica, enfermedad, tipo de tratamiento, etc., siempre y cuando se justifiquen brevemente las decisiones tomadas al respecto durante el diseño del sistema y los datos incluidos en cada caso. 

NO es necesario incluir un sistema de almacenamiento de datos para guardar/importar información      sobre el estado del hospital en un momento dado. Para no volver a teclear los datos necesarios para iniciar el sistema cada vez que se ejecuta el programa, el alumno puede preparar un método **iniciar()** con todas las llamadas necesarias incluyendo la información correspondiente. 

NO se requiere desarrollar una interfaz gráfica: basta con una simple serie de menús textuales, siendo      opcional el desarrollo gráfico si el alumno así lo estima oportuno. 

En esta práctica se propondrán diferentes funcionalidades en función de la calificación a la que se quiera aspirar. De este modo, una mayor complejidad a desarrollar implicará una calificación mayor en la evaluación de la práctica. Hay que tener en cuenta que **la nota mínima para aprobar** la práctica es 5.0. 

Es importante considerar que para optar a la calificación de un nivel superior han de cumplirse todas y cada una de las funcionalidades especificadas en el nivel inmediatamente anterior. En caso de no ser así (no cumplir con todos los requerimientos de un nivel), no se podrá obtener una calificación superior a la marcada por el nivel cuyas restricciones no se cumplen en su totalidad. Del mismo modo, los niveles han de implementarse en el orden que se indican, no siendo posible implementar niveles no consecutivos para obtener calificaciones superiores. 

Para cada uno de los niveles se van a indicar unos requisitos mínimos de cumplimiento. Esto quiere decir que para cualquier otro detalle de diseño que no se encuentre descrito expresamente en lo indicado  en  este  enunciado,  el  alumno  tiene  libertad  para  tomar  cuantas  decisiones  considere oportunas. 

Para obtener la nota mínima para aprobar hay que desarrollar los primeros **dos niveles** de la práctica. 

**Nivel 1 - Puntuación total máxima a obtener: 3 puntos.** 

Lo que se pretende que el alumno desarrolle en este nivel son las relaciones de clase, herencia y demás que van asociadas al desarrollo de la práctica. Así, se pide realizar las siguientes tareas: 

- Planteamiento del problema: actores participantes, relaciones entre actores, funcionalidad a cumplir por la práctica a desarrollar. 
- Establecimiento de diferentes clases a intervenir en la práctica, relaciones de dependencia entre clases, identificar diferentes jerarquías de clases, etc. 
- Elaboración de un documento escrito (memoria de la práctica) que contenga el primer punto y los correspondientes ficheros para BlueJ que implementen el segundo. 

**Nivel 2 - Puntuación total máxima a obtener: 7 puntos.** 

Los alumnos que implementen este nivel de finalización de la práctica recibirán una puntuación máxima de 7 puntos. Sólo se podrá optar a este Nivel si se ha implementado satisfactoriamente y en su  totalidad  los  requerimientos  especificados  en  el  Nivel  1.  Lo  que  se  pretende  que  el  alumno desarrolle en este nivel es la parte de gestión de datos del sistema usando una estructura de clases y métodos apropiados. De este modo, el sistema deberá permitir lo siguiente: 

- Dar de alta a los empleados del hospital, asignando cada uno a una unidad.  
- Dar de alta a los estudiantes, asignándoles clases en la unidad de formación con un miembro del personal médico/un miembro del personal de enfermería, o una cita (de mañana o tarde) con un miembro del personal médico para estar presentes durante las citas que tiene el especialista. 
- Dar de alta a los pacientes. 
- Dar una cita a un paciente para ver a un miembro del personal médico o un miembro del personal de enfermería (o para realizar una prueba médica) en una unidad en una fecha concreta, según la disponibilidad de cada especialista. La cita deberá quedar registrada en la agenda  del  miembro  del  personal  médico/miembro  del  personal  de  enfermería correspondiente. 
- Realizar el alta y la baja de pacientes ingresados en el hospital, asignándoles una habitación e indicando el procedimiento médico que tienen que recibir según su expediente médico.  
- Actualizar  el  expediente  médico  de  una  paciente  una  vez  terminada  una  consulta,  o tratamiento, por parte de un miembro del personal médico o un miembro del personal de enfermería. 
- Realizar búsquedas sencillas sobre los empleados y pacientes del sistema. 
- Realizar consultas y actualizaciones del calendario de cada miembro del personal médico/ miembro del personal de enfermería. 

**Nivel 3 - Puntuación total máxima a obtener: 10 puntos.** 

Los alumnos que implementen este nivel de finalización de la práctica recibirán una puntuación máxima de 10 puntos. Sólo se podrá optar a este Nivel si se han implementado satisfactoriamente y en su totalidad los requerimientos especificados en el Nivel 2. Lo que se pretende es que el alumno desarrolle en este nivel la interfaz textual del sistema para las funciones identificadas en el nivel 2 y la generación de listados. De este modo, el sistema deberá permitir lo siguiente: 

- Preparación  y  emisión  de  facturas  para  pacientes  sin  seguridad  social  o  seguro  médico privado. 
- Gestión  de  servicios  de  mantenimiento  (alta  y  baja  de  zz_recursos  dañados  que  requieren mantenimiento o reparación y asignación de cada caso a un técnico). 
- Visualización de diferentes tipos de datos del sistema: 
- Los empleados que hay en el sistema, clasificados por su unidad de trabajo. 
- Listado de las agendas de cada especialista (los miembros del personal médico o los miembros del personal de enfermería). 
- Listado de pacientes que tiene cada miembro del personal médico en una fecha concreta. 
- Listados de pacientes y sus expedientes médicos con diferentes criterios de búsqueda: 
- Pacientes ingresados. 
- Pacientes con citas en la agenda de consultas externas durante un periodo en concreto. 
- Pacientes  que  tienen  que  ver  un  especialista  (miembro  del  personal médico o miembro del personal de enfermería) en un periodo en concreto (día o semana). 
- Listado de ocupación de las habitaciones donde están ingresados los pacientes. 
5. **Plan de Trabajo** 

Para realizar la práctica se seguirá el siguiente método de trabajo: 

- En primer lugar, se leerá detenidamente el enunciado de esta práctica. 
- A continuación, hay que diseñar, utilizando un paradigma orientado a objetos, los elementos necesarios para cada nivel de la aplicación explicada en el apartado anterior. Debe hacerse uso de los mecanismos de herencia siempre que sea posible. Se valorará un buen diseño que favorezca la reutilización de código y facilite su mantenimiento. 
- El código estará debidamente comentado. 
- La clase principal que abre la aplicación deberá llamarse “**hospital.class**”. 
6. **Control de plagio en las prácticas** 

Tal y como está indicado en el apartado 10 de este documento, las prácticas son esenciales en las titulaciones de Informática porque permiten a los alumnos adquirir conocimientos importantes sobre los aspectos más aplicados de una asignatura. Por lo tanto, dado el hecho de que la práctica de esta asignatura es un trabajo individual y obligatorio que cuenta para la nota final de la asignatura y que implica un esfuerzo por parte de los alumnos, es necesario garantizar la originalidad de dicho trabajo. Para evitar este problema, una vez terminado el plazo de entrega de la práctica (indicado en el curso virtual), el equipo docente usará un software de control de plagio para revisar las prácticas. En los casos donde haya plagio se informará al Servicio de Inspección de la UNED para que tome las medidas disciplinarias apropiadas. 

7. **Normas de realización de la práctica** 
1. La realización de la práctica es obligatoria. Sólo se evaluará el examen si la práctica ha sido previamente aprobada. 
1. Aunque si bien el desarrollo de aplicaciones Orientadas a Objetos usando el lenguaje de programación Java no requiere el uso concreto de ningún entorno de desarrollo, está práctica ha de desarrollarse íntegramente empleando el entorno de desarrollo BlueJ, que es el que se muestra en el libro de texto básico de la asignatura. 
1. La práctica es un trabajo individual. Las prácticas cuyo código coincida total o parcialmente con el de otro alumno serán motivo de suspenso para todos los implicados (copiadores y copiados), no pudiéndose examinar ninguno de ellos en el presente curso académico (además de cualquier medida disciplinaria que aplicará el Servicio de Inspección). 
1. Cada tutor será responsable de organizar las sesiones de control presenciales o virtuales de la realización de la práctica: 
1. **Es el tutor el que marca la fecha de dicha sesión o sesiones y no el equipo docente**. Los tutores enviarán posteriormente listados de los alumnos que han asistido a dicha sesión. 
1. **La asistencia a dicha sesión (o una de ellas, si son varias) es obligatoria y se debería realizar antes de la entrega de la práctica en la plataforma**. 
1. El tutor puede organizar la sesión hacia el final del cuatrimestre para poder comprobar que los alumnos han hecho bien el trabajo y para ayudar al tutor a calificar el trabajo. 
4. El tutor entrará en el espacio virtual de la asignatura antes del 1 de junio, para meter las notas para sus alumnos. **En ningún caso esto significa que el plazo de entrega de la práctica será el 1 de junio**. Esta fecha es fijada exclusivamente por cada tutor en cada centro asociado y será anterior al desarrollo de las pruebas presenciales (primera y segunda semana). Por lo tanto, aún cuando el tutor es el único responsable de fijar esta fecha, **no podrá establecerse como fecha de entrega de la práctica obligatoria cualquier fecha posterior al 19 de mayo de 2024**. 
4. En el caso de que un alumno no pueda asistir a la sesión de control debido a una causa mayor (p.ej., por motivos médicos o de trabajo), se lo debería informar al equipo docente (adjuntando un certificado médico o carta de su empresa) antes del 19 de mayo de 2024. Una vez empezado el periodo de exámenes no se aceptarán estos avisos. 
4. Con  vistas  a  la  convocatoria  de  septiembre,  cada  tutor  habilitará  un  plazo extraordinario  de  entrega  de  las  prácticas.  Como  en  el  caso  anterior,  es responsabilidad  exclusiva  de  cada  tutor  el  establecimiento  de  dicha  fecha  y  la comunicación a sus alumnos. Es importante además tener en cuenta que, salvo que el  tutor  específicamente  así  lo  indique  y  exclusivamente  a  criterio  suyo,  **no  se establecerán sesiones de control extraordinarias con vista a la convocatoria de septiembre**. Por lo tanto, inexcusablemente, los alumnos, **con independencia de la convocatoria a la que vayan a presentar la práctica, deberán acudir a la sesión de control establecida en periodo ordinario** (es decir, entre febrero y mayo). 
4. Puede ocurrir que, por motivos organizativos del centro asociado, **algunos tutores puede que no lleven a cabo correcciones de prácticas con vistas a la convocatoria de septiembre**. En este caso (y solo para los alumnos cuyo tutor no corregirá prácticas en septiembre), se indicará pertinentemente la forma de proceder y cómo enviar la práctica para esa convocatoria en el curso virtual. 
5. La única vía de entrega de la práctica es a través de la plataforma de los cursos virtuales siguiendo las indicaciones del apartado 8. 
5. El equipo docente tendrá en cuenta prácticas con notas altas para aquellos alumnos cuyo examen esté cercano al aprobado. 
5. El alumno debería dirigirse a su tutor para cualquier duda que tenga sobre su práctica y solamente al equipo docente (por correo electrónico) en el caso de que su tutor no pueda resolver  su  problema.  En  este  caso,  pediremos  al  alumno  que,  además  de  sus  datos personales, nos envíe el nombre del centro asociado en el que está matriculado y el de su tutor. 
5. Evidentemente se pueden usar los foros para realizar consultas a los compañeros, pero nunca para intercambiar código. 

**8.  Entrega de la práctica** 

La práctica se entrega a través de la plataforma de los cursos virtuales en el apartado “Entrega de trabajos”. El archivo que hay que subir debe ser un archivo comprimido (rar o zip), que se puede preparar con el software de compresión que traen la mayoría de los sistemas operativos hoy en día o usando un software libre como 7zip (www.7-zip.org). **No se deben usar tildes** en los nombres de los archivos ni las carpetas. El archivo comprimido debe estar compuesto por una carpeta con el nombre del alumno que contendrá dos elementos: 

2. **Memoria**: La memoria constará de los siguientes apartados: 
   1. Portada con título “Práctica de Programación Orientada a Objetos – Curso 2023-2024” y los datos del alumno: Nombre, Apellidos, dirección de correo electrónico y teléfono de contacto. 
   1. Análisis  de  la  aplicación  realizada,  mostrando  el  funcionamiento  del  programa, estrategias implementadas, decisiones de diseño establecidas y, en general, toda aquella información que haga referencia a las diferentes decisiones tomadas a lo largo del desarrollo de la práctica, junto a una justificación de dichas decisiones. 
   1. Diagrama  de  clases,  detallando  claramente  el  tipo  de  relación  entre  ellas  (uso, agregación, herencia, ...). 
   1. Un  texto  en  el  que  se  describa  cada  clase/objeto,  justificación  de  su  existencia, métodos públicos que contiene y funcionalidad que realizan. 
   1. Anexo con el código fuente de las clases implementadas. 
2. **Una carpeta con el código**: incluyendo todos los ficheros \*.java y \*.class, así como la memoria en formato electrónico (preferiblemente html o pdf). 

**NOTAS:** 

- Al hacer la entrega del trabajo se acepta que tanto el código fuente Java como la memoria de la práctica son originales  Aquellos aportes intelectuales de otros autores (como por ejemplo, el tutor) deben estar referenciados debidamente en el texto de dicho trabajo. 
- Si el archivo subido por parte del alumno no sigue estas indicaciones, está infectado con algún virus, o que no se puede descomprimir, el Tutor (y por ende, el Equipo Docente) no aceptará la práctica y se calificará con una nota de 0. 
- La no inclusión de memoria alguna de la práctica igualmente acarreará una penalización en la calificación final de la misma, la cuál podría suponer el suspenso de la misma. 
- **Se vuelve a insistir en que la fecha de entrega de la práctica depende exclusivamente del tutor  asignado  para  su  corrección  en  el  centro  asociado  en  el  que  el  alumno  esté matriculado. Es fundamental que el alumno contacte con su tutor para conocer la fecha de entrega de la práctica. Este Equipo Docente no atenderá ningún tipo de reclamación al respecto**. 

**9.  Normas para los tutores** 

Como se puede apreciar, el papel del tutor es fundamental en todos los aspectos de la práctica, tanto el  planteamiento  del  problema,  el  diseño  orientado  a  objetos  del  programa,  su  desarrollo  y  su depuración. 

Tratándose de una asignatura obligatoria, cada alumno debería tener acceso a un tutor. Los tutores deben seguir los siguientes pasos: 

1. Ayudar a los alumnos al principio del curso con el planteamiento de la práctica y las normas que 

   tienen que seguir. 

2. Para explicar ciertos conceptos relacionados con la solución de la práctica, el tutor puede dar fragmentos de código fuente a los alumnos. Los pequeños fragmentos no tendrán importancia a la hora de llevar a cabo el control de plagio por parte del equipo docente. No obstante, si un alumno va a incluir un fragmento de código en su práctica, debe incluir un comentario al respecto directamente anterior al código y también una nota al respeto en su memoria. 
2. Indicar a los alumnos que habrá una sesión obligatoria de seguimiento y evaluación de la práctica. 
2. Una  vez  terminada  y  entregada  la  práctica,  el  tutor  debe  entrar  en  el  espacio  virtual  de  la asignatura, antes del 1 de junio, para introducir las notas de sus estudiantes. 
2. Comunicar la calificación a sus alumnos. 

**10.  Centros Asociados vs. Prácticas en Asignaturas Obligatorias** 

Las prácticas son esenciales en las titulaciones de Informática porque, entre otras cosas, permiten a los  alumnos  adquirir  conocimientos  importantes  sobre  los  aspectos  más  aplicados  de  ciertas asignaturas, lo cual resulta de gran relevancia e interés a la hora de acceder a un puesto laboral relacionado con la Informática. Para orientar y ayudar a los alumnos, así como para comprobar que realmente un alumno ha realizado su práctica de forma satisfactoria, ésta se debe realizar en un Centro Asociado bajo la supervisión de un tutor, quien decide, en última instancia, la forma en la cual se organiza el desarrollo de ésta en su Centro Asociado (existencia o no de sesiones presenciales obligatorias, forma de entrega, etc.). 

De  vez  en  cuando  sucede  que  un  alumno  se  pone  en  contacto  con  un  Equipo  Docente  del Departamento  de  Lenguajes  y  Sistemas  Informáticos  (L.S.I.)  porque  se  ha  matriculado  en  una asignatura obligatoria en un Centro Asociado que no le proporciona un tutor para supervisar la práctica, aún cuando se le ha permitido matricularse. El alumno busca en el Equipo Docente que se le proporcione una solución a este problema, como por ejemplo, la posibilidad de asistir a unas sesiones extraordinarias de prácticas en la Sede Central de la U.N.E.D. en Madrid o la posibilidad de realizar la práctica por su cuenta en casa, enviándola a continuación al Equipo Docente para su corrección. Sin embargo, los Equipos Docentes de L.S.I. no disponen de zz_recursos para poder llevar a cabo ninguna de estas dos alternativas. 

Un Centro Asociado que ha permitido a un alumno matricularse en una asignatura obligatoria de una carrera de Informática debería ayudarle a encontrar una solución al problema de la realización de las prácticas. Si se trata de una asignatura donde no se han matriculado muchos alumnos, quizás el centro no cuente con zz_recursos para proporcionar un tutor específicamente para la asignatura. Si hay otro Centro Asociado cerca que dispone de tutor, quizás el alumno pueda realizar la práctica allí. Pero si no es así, el Centro Asociado debería proporcionar un tutor para supervisar y corregir las prácticas de sus alumnos. Lo más razonable sería que fuera un tutor de otra asignatura de Informática en el mismo Centro el que hiciera la sesión de prácticas para los alumnos de la asignatura en cuestión, y al final de la sesión evaluase los trabajos de los alumnos, según las pautas marcadas por el Equipo Docente, haciendo llegar a éste las calificaciones otorgadas.

Por lo tanto, un alumno que, tras haberse matriculado en una asignatura obligatoria en un Centro Asociado, se encuentre con que el centro no tiene tutor para dicha asignatura, debería dirigirse al Director del Centro Asociado, para solicitar de él una solución, tal como se ha presentado aquí, es decir, alguien que pueda supervisar y corregir su práctica con plenas garantías. En el caso de que el Director no le proporcione una solución, el alumno debería comunicárselo, por escrito, lo antes posible, a la Directora del Departamento de L.S.I., Dra. Raquel Martínez. 
