package ddit.chap11.string;

// �� ���ڿ� ���տ����̳� �ݺ��Ǵ� ���ڿ� ���� ���꿡 ���
// StringBuffer - thread safe, StringBuilder - �Ϲ����� ���ڿ� ���տ��꿡 ȿ����
// StringBuilder�� �ֿ�޼���
// 1. ������
// StringBuilder([int capacity]) : capacity-���ۻ�����
// 2. append(������) : ������ ���ڿ� ���� '������'�� �߰��Ͽ� ����
// 3. insert(int offset, String str)
// 4. replace(int index1, int index2, String str) : index1���� index2-1���� ���ڿ��� str�� ��ü
// 5. toString() : StringŸ������ ��ȯ
public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); // ����Ʈ ���ۻ����� 16?
		sb.append(" select mem_id, mem_name, mem_hp, mem_mileage \n");
		sb.append("    from member \n");
		sb.append("    where mem_regno1 like '0%' ");
		String sql = sb.toString();
		System.out.println(sql);

		StringBuilder str = new StringBuilder("���ѹα�������");
		str.insert(4, "����");
		
		System.out.println(str.toString());
		
		str.replace(4, 9, "���");
		System.out.println(str.toString());
	}

}
