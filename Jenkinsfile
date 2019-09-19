pipeline {
    agent any
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'origin/develop', name: 'BRANCH', type: 'PT_BRANCH', sortMode: 'ASCENDING_SMART', quickFilterEnabled: true
    }
    environment{
        GIT_URL = "ssh://git@github.com:imadoor/spring-angular.git"
        SERVER_DIR = "rest-server"
        UI_DIR = "angular-client"
    }
    stages {
        stage('SCM Checkout'){
            steps{
                git branch: "${params.BRANCH}", url: "${GIT_URL}"
                sh "echo 'Environment Variables'"
                sh "printenv | sort"
            }

        }
        // Might be important for building 
        // use the COPY command to move the output files to the spring resources 
        // RUN npm run build -- --output-path=./dist
        stage('Back-end') {
            agent {
                docker { image 'maven:3-alpine' }
            }
            steps {
                sh 'mvn --version'
            }
        }
        stage('Front-end') {
            agent {
                docker { image 'node:7-alpine' }
            }
            steps {
                sh 'node --version'
            }
        }
    }
}