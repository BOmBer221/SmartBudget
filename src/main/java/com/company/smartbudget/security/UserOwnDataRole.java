package com.company.smartbudget.security;

import com.company.smartbudget.entity.*;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "UserOwnDataRole", code = UserOwnDataRole.CODE)
public interface UserOwnDataRole {
    String CODE = "user-own-data-role";

    @JpqlRowLevelPolicy(entityClass = Category.class,
            where = "{E}.user_id.id = :current_user_id")
    void ownCategories();

    // 2. Только свои счета
    @JpqlRowLevelPolicy(entityClass = Account.class,
            where = "{E}.user.id = :current_user_id") // поле user, не user_id!
    void ownAccounts();

    // 3. Только свои транзакции
    @JpqlRowLevelPolicy(entityClass = Transaction.class,
            where = "{E}.user_id.id = :current_user_id")
    void ownTransactions();

    // 4. Только свои цели
    @JpqlRowLevelPolicy(entityClass = Target.class,
            where = "{E}.user_id.id = :current_user_id")
    void ownTargets();

    // 5. Только свои рекомендации (если есть связь с User)
    @JpqlRowLevelPolicy(entityClass = Recommendation.class,
            where = "{E}.user_id.id = :current_user_id")
    void ownRecommendations();
}