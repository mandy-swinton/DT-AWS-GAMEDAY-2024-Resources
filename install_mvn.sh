echo "Installing Java and Maven"
sudo yum install -y java-11-amazon-corretto-headless
sudo wget https://www-eu.apache.org/dist/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz
sudo tar xf apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.8.8 /opt/maven
export M2_HOME = /opt/maven
export PATH = ${M2_HOME}/bin:${PATH}