#freelec-springboot2-webservice

외부에서 본인이 만든 서비스에 접근하려면 24시간 작동하는 서버가 필요
→ AWS 클라우드를 사용할 예정 (클라우드 : 인터넷을 통해 서버, 스토리지, 데이터베이스, 네트워크, 소프트웨어, 모니터링 등의 컴퓨터 서비스 제공)
AWS는 IaaS (IaaS : 기존 물리 장비를 미들웨어와 함께 묶어둔 추상화 서비스)

EC2는 AWS에서 제공하는 성능, 용량 등을 유동적으로 사용할 수 있는 서버
VPC와 서브넷 등은 AWS 서비스들의 네트워크 환경을 구성하는 정도로 이해하면 됨
스토리지 : 서버의 용량
태그 추가 : EC2의 이름
보안그룹 : 방화벽 역할
pem 키 관리와 지정된 IP에서만 ssh 접속이 가능하도록 구성하는것이 안전하다
외부 지역에서 접속할 경우, 해당 장소의 IP를 다시 SSH 규칙에 추가하는 것이 안전
인스턴스는 지정된 pem 키(비밀키)와 매칭되는 공개키를 가지고 있어, 해당 pem 키 외에는 접근을 허용하지 않는다.
일종의 마스터키이기 때문에 유출 X
같은 인스턴스를 중지하고 다시 시작할 때도 새 IP가 할당되기 때문에 탄력적 IP(EIP) 설정

Windows에서 EC2 서버를 접속할 경우 puttygen으로 pem 키를 ppk파일로 변환 후 putty에서 Load하여 사용한다
Host Name : username@public_ip → Amazon Linux@탄력적IP 등록
Post : ssh 접속포트인 22 등록
Connection type : ssh 선택

아마존 리눅스 서버 1을 처음 받았다면 초기 설정이 필요하다
1. Java 8 설치 : 현재 프로젝트 버전이 Java 8이기 때문
2. 타임존 변경 : 기본 서버시간이 미국 시간대이기 떄문에 한국 시간대로 변경
3. 호스트네임 변경 : 현재 접속한 서버의 별명을 등록, IP만으로는 어떤 서버가 어떤 역할을 하는지 알 수 없기 때문

AWS에서는 관리형 서비스인 RDS(Relational Database Service)를 제공한다
MariaDB : 동일 하드웨어 사양으로 MySQL보다 향상된 성능

git clone : 프로젝트 히스토리를 전부 다 받아온다 (git clone <url> 명령으로 저장소를 가져옴)
현재 EC2엔 Gradle을 설치하지 않았으나 Gradle Task를 수행할 수 있다. 이는 프로젝트 내부에 포함된 gradlew 파일 때문이다
그레이들이 설치되지 않은 환경 혹은 버전이 다른 상황에서도 해당 프로젝트에 한해서 그레이들을 쓸 수 있도록 지원하는 Wrapper 파일이다

배포 : 작성한 코드를 실제 서버에 반영하는 것
 1. get clone 혹은 git pull을 통해 새 버전의 프로젝트 받음
 2. Gradle이나 Maven을 통해 프로젝트 테스트와 빌드
 3. EC2 서버에서 해당 프로젝트 실행 및 재실행
 
 classpath가 붙으면 jar 안에 있는 resources 디렉토리를 기준으로 경로가 생성됨
 application-oauth.properties는 절대경로를 사용함, 외부에 파일이 있기 때문



