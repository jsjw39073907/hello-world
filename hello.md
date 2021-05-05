# hello git

## git 명령어 요약

- clone : 원격 저장소 복사
- add : 스테이지 영역에 작업 파일 추가
- commit : 세이브, 스테이지 영역의 파일들을 가지고 커밋(=save)를 만들 수 있다
- push : 원격 저장소에 커밋을 업로드한다

git push할 때 에러 해결 방법

- 에러 메시지
Updates were rejected because the remote contains work that you do not have locally

- 해결 방법
$ git pull origin master로 github의 저장 내용을 불러와 합친후 다시 $git push한다.

-원인
새 github repository를 README 파일과 함께 생성했기 때문이다.
