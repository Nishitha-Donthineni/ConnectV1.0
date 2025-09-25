pipeline {
    agent any

    // Make environment selectable at runtime
    parameters {
        choice(
            name: 'ENV', 
            choices: ['dev', 'qa', 'prod'], 
            description: 'Select the environment to run tests on'
        )
    }

    environment {
        MAVEN_HOME = tool(name: 'Maven 3', type: 'maven')
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building the project with Maven..."
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
                echo "Running TestNG tests on environment: ${params.ENV}"
                script {
                    if (isUnix()) {
                        sh "${MAVEN_HOME}/bin/mvn test -Denv=${params.ENV}"
                    } else {
                        bat "\"${MAVEN_HOME}\\bin\\mvn\" test -Denv=%ENV%"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to ${params.ENV} environment..."
                script {
                     if (isUnix()) {
                sh "./deploy.sh ${params.ENV}"
                   }
                    else 
                   {  bat "deploy.bat ${params.ENV}"
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
