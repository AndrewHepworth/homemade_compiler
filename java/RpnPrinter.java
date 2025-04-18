
//class RpnPrinter implements Expr.Visitor<String> {
//
//    String print(Expr expr) {
//        return expr.accept(this);
//    }
//
//    @Override
//    public String visitAssignExpr(Expr.Assign expr) {
//        return "";
//    }
//
//    @Override
//    public String visitBinaryExpr(Expr.Binary expr) {
//        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
//    }
//
//    @Override
//    public String visitGroupingExpr(Expr.Grouping expr) {
//        return parenthesize("group", expr.expression);
//    }
//
//    @Override
//    public String visitLiteralExpr(Expr.Literal expr) {
//        if (expr.value == null) return "nil";
//        return expr.value.toString();
//    }
//
//    @Override
//    public String visitUnaryExpr(Expr.Unary expr) {
//        return parenthesize(expr.operator.lexeme, expr.right);
//    }
//
//    @Override
//    public String visitVariableExpr(Expr.Variable expr) {
//        return "";
//    }
//
//    private String parenthesize(String name, Expr ...exprs) {
//        StringBuilder builder = new StringBuilder();
//        //builder.append("(").append(name);
//        for (Expr expression: exprs) {
//            builder.append(" ");
//            builder.append(expression.accept(this));
//        }
//        builder.append(" ");
//        builder.append(name);
//        //builder.append(")");
//
//        return builder.toString();
//    }
//
//    public static void main(String[] args) {
//        Expr minus = new Expr.Binary(
//                new Expr.Literal(4),
//                new Token(TokenType.MINUS, "-", null, 1),
//                new Expr.Literal(3)
//        );
//        Expr add = new Expr.Binary(
//            new Expr.Literal( 1),
//            new Token(TokenType.PLUS, "+", null, 1),
//            new Expr.Literal( 2)
//        );
//
//        Expr multiply = new Expr.Binary(
//            add,
//            new Token(TokenType.STAR, "*", null, 1),
//            minus
//        );
//        System.out.println(new RpnPrinter().print(multiply));
//    }
//}
