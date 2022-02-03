pipeline {
    agent all
    stages {
        stage('Example Test') {
            steps {
                echo 'Hello, JDK'
                sh './gradlew bootJar'
            }
        }
    }
}
