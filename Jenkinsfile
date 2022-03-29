pipeline {
    agent any {
    stages
      stage( 'deploy' ) {
        steps {
          script {
	        docker.withRegistry(
	          'https://046575588439.dkr.ecr.us-east-2.amazonaws.com',
		       'ecr:us-east-2:awsecr') {
		       def myImage = docker.build('test')
		       myImage.push('latest')
	    }
      }
    }
  }
  }
  }