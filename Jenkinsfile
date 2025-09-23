pipeline {
    agent any

    environment {
        ENV = "qa" // default environment
        MAVEN_HOME = tool(name: 'Maven 3', type: 'maven')
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project with Maven...'
                script {
                    if (isUnix()) {
                        sh "${MAVEN_HOME}/bin/mvn clean compile"
                    } else {
                        bat "\"${MAVEN_HOME}\\bin\\mvn\" clean compile"
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running TestNG tests...'
                script {
                    if (isUnix()) {
                        sh "${MAVEN_HOME}/bin/mvn test -Denv=${ENV}"
                    } else {
                        bat "\"${MAVEN_HOME}\\bin\\mvn\" test -Denv=%ENV%"
                    }
                }
            }
        }

        stage('Deploy to QA') {
            steps {
                echo 'Deploying to QA environment...'
                script {
                    if (isUnix()) {
                        sh "./deploy-to-qa.sh"
                    } else {
                        bat "deploy-to-qa.bat"
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Test, and Deployment completed successfully!'
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}
