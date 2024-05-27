pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'JDK11'
    }
    parameters {
        choice(name: 'ENV', choices: ['dev', 'uat'], description: 'Seleccionar ambiente')
        string(name: 'SCENARIO_TAG', trim: false, description: 'Tag a ejecutar')
    }
    stages {
        stage('Build'){
            steps{
                script{
                    if(isUnix()){
                        sh "java -version"
                        sh "mvn clean install -DskipTests"
                    }
                    else{
                        bat "java -version"
                        bat "mvn clean install -DskipTests"
                    }
                }
            }
        }
        stage('Execute Tests'){
            steps{
                script{
                    try{
                        if(isUnix()){
                            echo "Executing tag: ${params.SCENARIO_TAG}"
                            sh 'mvn clean verify -Dcucumber.filter.tags="${SCENARIO_TAG}"'
                        }
                        else {
                            echo "Executing tag: ${params.SCENARIO_TAG}"
                            bat 'mvn clean verify -Dcucumber.filter.tags="${params.SCENARIO_TAG}"'
                        }
                    } finally{
                        publishReport();
                    }
                }
            }
        }
    }
}

    def publishReport(){
        publishHTML(target: [
            reportName: 'Serenity Report',
            reportDir: 'target/site/serenity',
            reportFiles: 'index.html',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }