# Conta Teste - Cucumber

## Sobre
Exercício desenvolvido durante a disciplina **Qualidade e Teste de Software** com o objetivo de compreender a importância do teste de software durante o desenvolvimento do mesmo utilizando o BDD.


## Pré-requisitos

Antes de começar, é ideal ter o [Git](https://git-scm.com) instalado, e as seguintes tecnologias para a execução do projeto:

* [Java 8](https://www.oracle.com/br/java/technologies/downloads/) , [leia](#configurando-java-home-no-windows) antes de instalar;

* [Eclipse](https://www.eclipse.org/downloads/) **, ou outra IDE de sua preferência**.


## Configurando JAVA-HOME no Windows
1. Copie o caminho de instalação do Java JDK em um bloco de notas, deve ser parecido com o seguinte caminho;<br>
`C:\Program Files\Java\jdk1.8.0_341`
2. Em inicar, procure por PowerShell e abra como administrador;
3. Copie a seguinte linha de código e substitua **PATH** pelo caminho copiado;
```
[Environment]::SetEnvironmentVariable("JAVA_HOME", "PATH", "Machine")
```
4. Copie a seguinte linha de código e substitua **PATH** pelo caminho copiado só que dessa vez incluindo a pasta **bin**, deve ser parecido com o seguinte caminho;<br>
`C:\Program Files\Java\jdk1.8.0_341\bin`
```
$OLDPATH = [System.Environment]::GetEnvironmentVariable('PATH','machine')
$JAVAPATH = [System.Environment]::GetEnvironmentVariable('JAVA_HOME','machine')
$NEWPATH = "$OLDPATH;$JAVAPATH\bin"
[Environment]::SetEnvironmentVariable("PATH", "$NEWPATH", "Machine")
```
5. Em iniciar, procure por **prompt**, **cmd** ou **dos**;
6. Para verificar se o JAVA-HOME está configurado, a saída deve ser parecida com o seguinte caminho, após a execução do comando abaixo;
`C:\Program Files\Java\jdk1.8.0_341`
```
echo %JAVA_HOME%
```
7. Para verificar a aplicação Java, a saída deve ser parecida com a seguinte, após a execução do comando abaixo.<br>
`java version "11.0.16" 2022-07-19 LTS`<br>
`Java(TM) SE Runtime Environment 18.9 (build 11.0.16+11-LTS-199)`<br>
`Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.16+11-LTS-199, mixed mode)`
```
java -version
```

## Configurando o Cucumber no Eclipse
1. Abra o Eclipse IDE, e clique em **Launch**;
2. Após aberto, procure pela opção **Help** na barra superior e a selecione;
3. Clique em **Eclipse Marketplace**, e em **Find** pesquise por:
```
cucumber
```
4. Clique em **Install** para o plugin ***Cucumber Eclipse Plugin***;
5. Siga as instruções que seram apresenstadas;
6. Será solicitado que a IDE seja reiniciada;
7. Após reiniciada, o ***Cucumber*** estará pronto para ser utilizado.

## Clone este repositório
```
git clone https://github.com/sergiotavuencas/conta_teste-cucumber
```


## Executando
Basta abrir o repositório na IDE e executar o arquivo ***conta_bdd.feature***.


## Tecnologias
* Eclipse IDE 2022-06
* Java 8
* Cucumber 7.8.1
