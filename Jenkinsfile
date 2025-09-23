pipeline {
    agent any

    // Define environment variables
    environment {
        ENV = "qa" // default environment
        MAVEN_HOME = tool(name: 'Maven 3', type: 'maven') // your Maven installation in Jenkins
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
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running TestNG tests...'
                sh "${MAVEN_HOME}/bin/mvn test -Denv=${ENV}"
            }
        }

        stage('Deploy to QA') {
            steps {
                echo "Deploying to QA environment..."
                // Replace below with your actual deployment command/script
                sh "bash deploy-to-qa.sh" 
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
