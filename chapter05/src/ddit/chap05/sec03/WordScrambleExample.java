package ddit.chap05.sec03;

//5���� �ܾ �迭�� ������ �� ������ �� �ܾ �����Ѵ�
//���õ� �ܾ��� ö�ڸ� ���� ����ڿ��� �����Ѵ�
//����ڴ� ���õ� ö�ڵ��� ���� ������ �ܾ ���ߴ� ����
//�õ�Ƚ���� ���
public class WordScrambleExample {

	public static void main(String[] args) {
		WordScramble ws = new WordScramble();
		String str = ws.getWord(); // ����
		String question = ws.shuffle(str);
		System.out.println("���þ� : " + question);
		ws.answer(str);

	}
}
