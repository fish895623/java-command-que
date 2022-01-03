pipeline {
    agent none
    stages {
        stage('Example Build') {
            agent { docker 'maven:3.8.1-adoptopenjdk-11' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Example Test') {
            agent { docker 'openjdk:11-jdk' }
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}
