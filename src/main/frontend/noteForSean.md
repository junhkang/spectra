1. frontEnd 프로젝트 src/main에 생성
2. package.json에 proxy 설정 
3. yarn install / yarn build -> 빌드 파일 백엔드의 resources/static 폴더에 복붙
4. pom.xml에 복붙한 static 파일들을 frontEnd가 build될 때마다 자동으로 업데이트 되게 하는 플러그인을 추가 
5. DashBoardController.java 에서 GetMapping으로 들어올 때 static/index.html로 들어오게 포워드 해줌 
    forward:/라고 한 이유는 타임리프때문에 templates에서 파일을 먼저 읽어서 static으로 안 갈 수 있는 것을 static에서 먼저 읽을 수 있게 해주는 것이라고 함.
