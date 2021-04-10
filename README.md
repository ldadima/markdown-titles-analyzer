#Markdown titles analyzer
* Для запуска приложения и тестов можно использовать
  Intellij IDEA и OpenJDK15.
  Для запуска и сборки тестов использовать Maven (желательно версии 3.6.0+).
  В папке `src/main/resources` лежит пример markdown файла 
* Также запустить приложение можно с помощью следующей
  последовательности команд (из папки `src/main/java`):
    * `javac Application.java` (если не сработает, то `javac -encoding utf8 Application.java`)
    * `java Application filename` (если не сработает, то `java -classpath $PWD Application filename`)
* Для иного запуска тестов нужен установленный Maven (желательно версии 3.6.0+) и
  воспользоваться командой:
    * `mvn test` (из папки проекта)
    * `java Application filename`(из папки `target/classes`) для иного запуска приложения, скомпилированное с помощью maven
      (если не сработает, то `java -classpath $PWD Application filename`)
