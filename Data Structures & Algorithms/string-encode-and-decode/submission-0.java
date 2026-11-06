class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str:strs) {
            builder.append(str.length())
            .append("#").append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        
        int length;

        List<String> decoded = new ArrayList<>();
        while(index < str.length()) {
            while(str.charAt(index) != '#') {
                builder.append(str.charAt(index++));
            }
            length = Integer.parseInt(builder.toString());
            index++;
            // if(index == str.length()) {
            //     break;
            // }
            decoded.add(str.substring(index, index + length));
            index+=length;
            builder.setLength(0);
        }

        return decoded;
    }
}
