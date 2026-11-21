pipeline {
    agent any

    tools {
        maven 'M3'   // nom du Maven configuré dans Jenkins (Manage Jenkins > Tools)
    }

    triggers {
        // Déclenché par le webhook GitHub (push)
        githubPush()
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le projet depuis GitHub
                git branch: 'main', url: 'https://github.com/Amalzouari123456/DevOps-AppGestionDesProjets.git'
            }
        }

        stage('Tests unitaires') {
            steps {
                dir('backend') {
                    sh 'mvn -B clean test'
                }
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'backend/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                dir('backend') {
                    // Livrable (jar) généré dans backend/target
                    sh 'mvn -B package -DskipTests'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: 'backend/target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        failure {
            mail to: 'amalzouari55@gmail.com',
                 subject: "Échec du build : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "La construction a échoué.\n\nJob : ${env.JOB_NAME}\nBuild : #${env.BUILD_NUMBER}\nDétails : ${env.BUILD_URL}"
        }
    }
}