VSCode Config.

{
    "java.compile.nullAnalysis.mode": "automatic",
    "java.home": "C:/workspace/core.naveapi/tools/jdk-21",
    "java.configuration.runtimes": [
      {
        "name": "JavaSE-21",
        "path": "C:/workspace/core.naveapi/tools/jdk-21",
        "default": true
      }
    ],
    "terminal.integrated.env.windows": {
        "JAVA_HOME": "C:/workspace/core.naveapi/tools/jdk-21",
        "MAVEN_HOME": "C:/workspace/core.naveapi/tools/apache-maven-3.9.9",
        "Path": "C:/workspace/core.naveapi/tools/apache-maven-3.9.9/bin;${env:Path}"
      }
  }
  

