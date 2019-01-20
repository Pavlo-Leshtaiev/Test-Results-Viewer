pipeline {
    agent any
    tools {
        maven 'Maven 3.6.0'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                echo 'Current path: %PATH%'
                echo 'Current path: $PATH'
                echo 'Current path: $Path'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                echo 'This is a minimal pipeline. To test hooks config 6.'
            }
        }
    }
}