pipeline {
  agent any
  stages{
  	stage('Build and Test') {
  	  steps {
  	  	mvn -version
        mvn clean install
      }
  	}
  }
}