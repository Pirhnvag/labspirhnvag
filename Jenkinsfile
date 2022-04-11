Skip to content
Product 
Team
Enterprise
Explore 
Marketplace
Pricing 
Search
Sign in
Sign up
Pirhnvag
/
labspirhnvag
Public
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
labspirhnvag/Jenkinsfile

projel listo a dormir, salio exitoso
Latest commit 1702e0f 5 days ago
 History
 0 contributors
69 lines (67 sloc)  1.72 KB
   
pipeline {
    agent any
    tools {
		maven "Maven3"
	}
	
	environment {
		def pkgName = 'company-api-rest-crud-completo'
	}
    stages {
        stage('Build & Test') { 
            steps {
                sh 'mvn clean test'
            }
        }
        stage('SonarQube') {
        steps {
				withSonarQubeEnv('SonarQube') {
					script {
						//def fixedBranchName = env.GIT_BRANCH.replace("origin/", "").replace("/", "_")
						sh 'mvn sonar:sonar -Dsonar.projectName=$pkgName:' + ' -Dsonar.projectKey=$pkgName:'
					}
				}
			}
		}
		stage('SonarQube Quality Gate') {
			steps {
				echo 'Esperando respuesta analisis SonarQube'
				timeout(5) {
					waitForQualityGate abortPipeline: false, credentialsId: 'SONARQUBE_TOKEN'
				}
			}
		}
        stage('Compile Application') {
			steps {
				sh 'mvn package -DskipTests'
			}
		}
		stage('Save Artifacts y/o Apllication') {
			steps {
				archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
			}
		}
		stage('Delivery Application') {
            steps {
          sshagent(credentials: ['f385715f-c26e-497c-8969-e0bb277197e6']) {
            sh '''         
              scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/PIPELINE-API-REST-SPRINGBOOT/target/demo-0.0.1-SNAPSHOT.jar azureuser@20.127.128.16:/home/azureuser/
              scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/PIPELINE-API-REST-SPRINGBOOT/Dockerfile azureuser@20.127.128.16:/home/azureuser/
            '''                 
            }
        }
        }
        stage('Deploy Application') {
            steps {
          sshagent(credentials: ['f385715f-c26e-497c-8969-e0bb277197e6']) {
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'cd /home/azureuser/' && 'docker build -t apicrud .' && 'sleep 10'
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 && 'docker stop container1 && 'docker run -p8090:8080 -d  --name container1 apicrud''
            '''
                }
            }
        }
	}
	post {
		always {
			echo 'Build CI/CD completo'
		}
	}
} 