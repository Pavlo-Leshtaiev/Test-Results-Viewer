pipeline {
    agent any
    stages {
        tools {
            maven 'Maven 3.3.9'
            jdk 'jdk11'
        }
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                echo 'This is a minimal pipeline. To test hooks config.'
            }
        }
    }
}