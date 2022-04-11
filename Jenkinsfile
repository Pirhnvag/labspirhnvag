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
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'docker build -t apicrud .'
               '''
            sleep(time: 10, unit: 'SECONDS')
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'docker run -p8090:8080 -d  --name container_test apicrud'
               '''
            sleep(time: 10, unit: 'SECONDS')
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'docker kill $(docker ps -q)'
               '''
            sleep(time: 2, unit: 'SECONDS')
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'docker rm $(docker ps -a -q)'
               '''
            sleep(time: 2, unit: 'SECONDS')
            sh '''
               ssh -o StrictHostKeyChecking=no azureuser@20.127.128.16 'docker run -p8090:8080 -d  --name container-prd apicrud'
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