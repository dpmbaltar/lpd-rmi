# lpd-rmi

Pre-requisitos: JDK 19.

Para compilar y ejecutar el código:

1. Ejecutar desde una terminal o consola:

  ```
  javac -sourcepath src -d bin src/lpd/rmi/client/Cliente.java \
                               src/lpd/rmi/server/ServidorPronostico.java \
                               src/lpd/rmi/server/ServidorHoroscopo.java \
                               src/lpd/rmi/server/ServidorCentral.java
  ```
2. Para lanzar los programas, ejecutarlos en el siguiente orden:
    1. Servidor pronóstico: `java -classpath bin lpd.rmi.server.ServidorPronostico 127.0.0.1 24001`
    2. Servidor horóscopo: `java -classpath bin lpd.rmi.server.ServidorHoroscopo 127.0.0.1 24002`
    3. Servidor central: `java -classpath bin lpd.rmi.server.ServidorCentral 127.0.0.1 24000`
    4. Servidor cliente: `java -classpath bin lpd.rmi.client.Cliente`
