# Croffle Project
### _집중력 향상을 도와주는 타이머 앱_
>경상국립대학교 컴퓨터과학과 19학번
>팀장 박주철, 팀원 김예원, 팀원 최정민

# 개요
집중력 향상을 도와주는 타이머 앱(MyTime)은 사람의 안면 움직임을 감지하여 집중력 유지 여부를 판별하고, 여기에 따라 집중력 향상을 위한 안내 및 통계를 제공하는 안드로이드 기반의 타이머 애플리케이션이다.
***
# 상세
### 개발 인원
 - 팀장 박주철
   - 프로젝트 지휘
   - 머신러닝 및 집중력 감지 기능 개발
   - 관련 기능 연동 및 최적화
   - 데이터베이스 설계 및 구축
 - 팀원 김예원
   - 유저 인터페이스 설계
   - 타이머 메인 페이지 및 타이머 설정 기능 개발
   - roomDB 구축 및 사용
 - 팀원 최정민
   - 통계 페이지에 대한 화면 및 기능 설계와 구현
   - 데이터베이스 생성 및 관리
   - 기능에 맞는 데이터베이스 연동

### 개발 기술
본 프로젝트 개발에 사용된 라이브러리 및 파이프라인입니다.
- [MPAndroidChart] - 차트 생성 라이브러리
- [Toggle Button Group] - 다중 선택 토글
- [Android Jetpack] - 고품질 개발 라이브러리 및 툴 모음집
- [RxJava] - 반응형 프로그래밍 라이브러리
- [Mediapipe] - 라이브 머신러닝 파이프라인

### 개발 환경
| 종류 | 목록 |
| ------ | ------ |
| 사용 언어 | Java(1.8), Python(3.7), C++ |
| 개발 도구 | Android Studio(2021.1.1.) - SDK(31.0) & NDK(20.1.5948944) |
| 데이터베이스 | Room persistence library |
| OS 환경 | Windows 10, Ubuntu 22.04 LTS |

### 사용 방법
본 프로젝트의 결과물을 시연하는 방법입니다.
- 해당 프로젝트를 다운로드 받고, 안드로이드 스튜디오에서 실행시킵니다.
- 다만 해당 프로젝트는 스마트폰 카메라를 사용하는 관계로 안드로이드 애뮬레이터에서는 작동하지 않습니다.
- 안드로이드 스튜디오에서 .apk 형식으로 빌드합니다.
- 애플리케이션을 스마트폰으로 옮긴 다음 실행합니다.

### 포크 & 모듈 & 리포지토리
본 프로젝트의 포크 혹은 별도로 분리되어 개발된 모듈 혹은 추가 리포지토리 목록입니다.
- [Original Repository] - 본래 개발이 진행되던 Repository입니다. 오류로 인해 중단되었습니다.
- [Now Repository] - Original Repository 중단 이후 옮긴 Repository입니다. 현 Repository입니다.
- [박주철 Fork] - 박주철이 개발을 위해 만든 Fork입니다.
- [최정민 Fork] - 최정민이 개발을 위해 만든 Fork입니다.
- [focusDetection] - 머신러닝 및 집중력 감지 기능 제작을 위해 박주철이 별도로 만든 애플리케이션입니다.

### 자료
본 개발을 하면서 작성된 보고서 및 발표 자료입니다. 
| 보고서 자료 | 발표 자료 |
| ------ | ------ |
| [제안서 PDF 링크](https://drive.google.com/file/d/1RwU63yPlyBcWT9bWmEsz1pcOw9JedkQL/view?usp=sharing) | [제안 발표 PPT 링크](https://docs.google.com/presentation/d/1KADp_gD_h1vP915ErezeJy9oqhHexCcI/edit?usp=sharing&ouid=106667079864051075882&rtpof=true&sd=true) |
| [중간 보고서 PDF 링크](https://drive.google.com/file/d/1476yIUlSrrknN8vHfHZWq7NfA9Gfya-M/view?usp=sharing) | [중간 발표 PPT 링크](https://docs.google.com/presentation/d/1u-o4p1oI6acgfBK_YJFMi3Udabco77Sd/edit?usp=sharing&ouid=106667079864051075882&rtpof=true&sd=true) |
| 보고서 없음 | [개인별 개발 발표 PPT 링크](https://docs.google.com/presentation/d/1GXnHvq4z69BQfnfqXlxXNyn5XZIUd_5v/edit?usp=sharing&ouid=106667079864051075882&rtpof=true&sd=true) |
| [최종 보고서 PDF 링크](https://drive.google.com/file/d/1_vAOef2ahsxdgg7nUsABWzQahMgHjQKe/view?usp=sharing) | [최종 발표 PPT 링크](https://docs.google.com/presentation/d/1Haj2cr8d3ndEf8QGRnZpysfI8OgpFn0f/edit?usp=sharing&ouid=106667079864051075882&rtpof=true&sd=true) |

***
# 향후 계획
- 최적화 개선, 저사양 및 구형 스마트폰에서의 원활한 작동이 되도록 최적화 개선이 필요
- 안정성 개선, 앱의 크래시 현상 및 데이터베이스 오작동 문제의 개선이 필요
- 편의성 개선, 타이머 연장 기능 개발 및 기타 편의성 측면에서의 개선이 필요
- 통계 기능 강화, 빈약한 통계 기능에 대한 대대적인 강화가 필요
- 도움말 기능 강화 및 추가, 없거나 적은 도움말 기능에 대한 대대적인 강화가 필요


   [MPAndroidChart]: <https://github.com/PhilJay/MPAndroidChart>
   [Toggle Button Group]: <https://github.com/nex3z/ToggleButtonGroup>
   [Android Jetpack]: <https://github.com/androidx/androidx>
   [RxJava]: <https://github.com/ReactiveX/RxJava>
   [Mediapipe]: <https://github.com/google/mediapipe>


   [Original Repository]: <https://github.com/wncjf2000/Croffle-Project>
   [Now Repository]: <https://github.com/yewon5858/Croffle-Project>
   [박주철 Fork]: <https://github.com/wncjf2000/Croffle-Project-1>
   [최정민 Fork]: <https://github.com/spyker73/Croffle-Project>
   [focusDetection]: <https://github.com/wncjf2000/focusDetection>
