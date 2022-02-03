pipeline {
    agent any
    stages {
        stage('Example Test') {
            steps {
                echo 'Hello, JDK'
                sh './gradlew bootJar'
            }
        }
    }
}
