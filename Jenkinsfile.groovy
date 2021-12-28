pipeline {
    agent none
    stages {
        stage('gradle test') {
            agent { docker 'openjdk:11.0.13-slim' }
            steps {
                sh './gradlew test'
            }
        }
    }
}
