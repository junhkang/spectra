<p align="center">
  <img src="https://github.com/junhkang/spectra/assets/20232155/545cac07-540d-446d-b9c0-b92daa3221c9" alt="spectra" width="200">
</p>
<p align="right">
  <a href="/localization/en"><img src="https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg" width="30"></a>
  <a href="#"><img src="https://upload.wikimedia.org/wikipedia/commons/0/09/Flag_of_South_Korea.svg" width="30"></a>
</p>

## 개요

Spectra는 Spring Boot와 Thymeleaf로 구축된 포괄적인 데이터베이스 대시보드 애플리케이션입니다. 인덱스 튜닝, 외래 키, 기본 키, 데이터 사용량, CPU 사용량 등을 포함한 다양한 데이터베이스 모니터링 및 관리 기능을 제공합니다. 이 애플리케이션은 사용자에게 데이터베이스 성능에 대한 자세한 통찰을 제공하고 잠재적인 문제와 최적화 경로를 식별하는 데 도움을 줍니다.

## 기능

- **데이터베이스 모니터링**: 인덱스, 외래 키, 기본 키, 데이터 사용량, CPU 사용량과 같은 다양한 데이터베이스 지표의 실시간 모니터링.
- **인덱스 튜닝**: 데이터베이스 인덱스를 최적화하기 위한 도구와 권장 사항.
- **알림 및 통지**: 잠재적인 문제와 성능 병목 현상에 대한 실시간 알림.
- **사용자 정의 대시보드**: 주요 지표를 표시하기 위한 사용자 친화적이고 사용자 정의 가능한 대시보드.
- **상세 보고서**: 데이터베이스 성능에 대한 상세 보고서 생성 및 내보내기.
- **과거 데이터 분석**: 추세와 패턴을 식별하기 위해 과거 데이터를 추적하고 분석.
- **사용자 관리**: 역할 기반 접근 제어 및 사용자 관리 기능.
- **확장성**: 대용량 데이터셋과 높은 트래픽 부하를 처리하도록 설계됨.

## 설치

1. 리포지토리를 클론합니다:
   ```bash
   git clone https://github.com/junhkang/spectra.git
   cd spectra
   ```

2. 애플리케이션을 빌드하고 실행합니다:
   ```bash
   ./mvnw spring-boot:run
   ```

3. 브라우저를 열고 `http://localhost:8080`으로 이동하여 대시보드에 접근합니다.

## 사용법

1. **데이터베이스 연결**: 데이터베이스 연결 정보를 입력하여 모니터링을 시작합니다.
2. **대시보드**: 대시보드를 사용하여 실시간 지표와 성능 지표를 확인합니다.
3. **보고서**: 데이터베이스의 다양한 측면에 대한 상세 보고서를 생성합니다.
4. **알림**: 잠재적인 문제를 알리기 위한 알림을 구성합니다.

## CONTRIBUTE

기여는 언제나 환영입니다! 참여 방법에 대한 지침은 [CONTRIBUTING.md](/CONTRIBUTING.md)를 참조하세요.

## LICENSE

이 프로젝트는 MIT 라이선스에 따라 라이선스가 부여됩니다 - 자세한 내용은 [LICENSE](/LICENSE) 파일을 참조하세요.

## CONTACT

질문, 제안 또는 문제가 있는 경우 [issue tracker](https://github.com/junhkang/spectra/issues)에 새 이슈를 생성하거나 [junhkang91@gmail.com](mailto:junhkang91@gmail.com)으로 연락해 주세요.

## 기여자

이 프로젝트는 다음과 같은 기여자들의 도움으로 이루어졌습니다:

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/junhkang"><img src="https://avatars.githubusercontent.com/u/20232155?v=4?s=100" width="100px;" alt="Jun Kang"/><br /><sub><b>Jun Kang</b></sub></a><br /><a href="https://github.com/junhkang/spectra/commits?author=junhkang" title="Code">💻</a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->
