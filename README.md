⛺ 캠프 관리 프로그램
- 내배캠 스프링 수강생들을 관리하는 프로그램
  
* 기능 : 담당

[수강생 관리] 
1. 수강생 정보 등록  : 이종원 
  - 고유 번호
  - 이름
  - 과목 목록
  - 수강생 상태
  ✅ 수강생의 고유 번호는 중복될 수 없다
  ✅ 선택한 필수 과목이 3개 미만일 수 없다
  ✅ 선택한 선택 과목이 2개 미만일 수 없다

2. 수강생 목록 조회 : 이건희
  - 고유 번호
  - 이름
  - 상태
  - 선택한 과목명
  
3. 상태별 수강생 목록 조회 : 이종원
  - 고유 번호
  - 이름
4. 수강생 상태 & 정보 수정 : 박수민

  이름 또는 상태를 입력받아 수정
  - 이름
  - 상태
5. 수강생 삭제 : 채은지
  해당 수강생의 점수 기록도 함께 삭제

[점수 관리]
1. 수강생의 과목별 시험 회차 및 점수 등록 : 이재형
  점수를 등록하면 자동으로 등급이 추가 저장
  ✅ 등록하려는 과목의 회차 점수가 이미 등록되어 있다면 등록할 수 없다.
  ✅ 회차에 10 초과 및 1 미만의 수가 저장될 수 없다. (회차는 1 ~ 10)
  ✅점수에 100 초과 및 음수가 저장될 수 없다. (점수는 0 ~ 100)

2. 수강생의 과목별 회차 점수 수정 : 박수민

3. 수강생의 특정 과목 회차별 등급 조회 : 채은지
  - 회차
  - 등급

4. 수강생의 과목별 평균 등급을 조회 : 채은지
  - 과목명
  - 평균 등급

5. 특정 상태 수강생들의 필수 과목 평균 등급을 조회 : 이재형
  - 수강생 이름
  - 필수 과목 평균 등급
    
클래스 필드 수정, 테스트 : 전부 참여, README 작성 : 채은지
